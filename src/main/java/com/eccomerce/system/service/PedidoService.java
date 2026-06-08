package com.eccomerce.system.service;

import com.eccomerce.system.dto.PedidoDTO;
import com.eccomerce.system.mapper.PedidoMapper;
import com.eccomerce.system.model.EstadoPedido;
import com.eccomerce.system.model.Pedido;
import com.eccomerce.system.repository.PedidoRepository;
import com.eccomerce.system.serialization.PedidoBackupService;
import com.eccomerce.system.socket.PedidoNotificationService;
import com.eccomerce.system.thread.PedidoExecutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final PedidoNotificationService notificationService;
    private final PedidoExecutorService pedidoExecutorService;
    private final PedidoBackupService backupService;

    public List<PedidoDTO> listarPedidos() {

        return pedidoMapper.toDTOList(
                pedidoRepository.findAll()
        );

    }

    public PedidoDTO obtenerPedido(Long id) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pedido no encontrado"));

        return pedidoMapper.toDTO(pedido);

    }

    public PedidoDTO crearPedido(PedidoDTO dto) {

        Pedido pedido = pedidoMapper.toEntity(dto);

        pedido.setEstado(
                EstadoPedido.valueOf(dto.getEstado())
        );

        pedido.setTotal(dto.getTotal());

        Pedido pedidoGuardado =
                pedidoRepository.save(pedido);

        backupService.backup(
                pedidoGuardado
        );

        pedidoExecutorService.procesarPedido(
                pedidoGuardado
        );

        notificationService.nuevoPedido(
                pedidoGuardado.getId(),
                pedidoGuardado.getTotal()
        );

        return pedidoMapper.toDTO(
                pedidoGuardado
        );

    }

    public PedidoDTO actualizarPedido(
            Long id,
            PedidoDTO dto) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Pedido no encontrado"
                        ));

        pedido.setEstado(
                EstadoPedido.valueOf(dto.getEstado())
        );

        pedido.setTotal(dto.getTotal());

        Pedido pedidoActualizado =
                pedidoRepository.save(pedido);

        notificationService.actualizarPedido(
                pedidoActualizado.getId(),
                pedidoActualizado.getEstado().name()
        );

        return pedidoMapper.toDTO(
                pedidoActualizado
        );

    }

    public void eliminarPedido(Long id) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pedido no encontrado"));

        pedidoRepository.delete(pedido);

    }

}