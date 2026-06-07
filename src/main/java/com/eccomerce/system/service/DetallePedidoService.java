package com.eccomerce.system.service;

import com.eccomerce.system.dto.DetallePedidoDTO;
import com.eccomerce.system.mapper.DetallePedidoMapper;
import com.eccomerce.system.model.DetallePedido;
import com.eccomerce.system.repository.DetallePedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;
    private final DetallePedidoMapper detallePedidoMapper;

    public List<DetallePedidoDTO> listarDetalles() {

        return detallePedidoMapper.toDTOList(
                detallePedidoRepository.findAll()
        );

    }

    public DetallePedidoDTO obtenerDetalle(Long id) {

        DetallePedido detalle = detallePedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Detalle no encontrado"));

        return detallePedidoMapper.toDTO(detalle);

    }

    public DetallePedidoDTO crearDetalle(DetallePedidoDTO dto) {

        DetallePedido detalle = detallePedidoMapper.toEntity(dto);

        return detallePedidoMapper.toDTO(
                detallePedidoRepository.save(detalle)
        );

    }

    public DetallePedidoDTO actualizarDetalle(
            Long id,
            DetallePedidoDTO dto) {

        DetallePedido detalle = detallePedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Detalle no encontrado"));

        detalle.setCantidad(dto.getCantidad());

        return detallePedidoMapper.toDTO(
                detallePedidoRepository.save(detalle)
        );

    }

    public void eliminarDetalle(Long id) {

        DetallePedido detalle = detallePedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Detalle no encontrado"));

        detallePedidoRepository.delete(detalle);

    }
}