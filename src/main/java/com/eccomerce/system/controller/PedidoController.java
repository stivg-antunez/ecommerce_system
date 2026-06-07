package com.eccomerce.system.controller;

import com.eccomerce.system.dto.PedidoDTO;
import com.eccomerce.system.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public List<PedidoDTO> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public PedidoDTO obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedido(id);
    }

    @PostMapping
    public PedidoDTO crearPedido(
            @Valid
            @RequestBody PedidoDTO dto) {

        return pedidoService.crearPedido(dto);

    }

    @PutMapping("/{id}")
    public PedidoDTO actualizarPedido(
            @PathVariable Long id,
            @Valid
            @RequestBody PedidoDTO dto) {

        return pedidoService.actualizarPedido(id, dto);

    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }

}