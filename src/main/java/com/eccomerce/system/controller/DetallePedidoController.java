package com.eccomerce.system.controller;

import com.eccomerce.system.dto.DetallePedidoDTO;
import com.eccomerce.system.service.DetallePedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
@RequiredArgsConstructor
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetallePedidoDTO> listarDetalles() {
        return detallePedidoService.listarDetalles();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DetallePedidoDTO obtenerDetalle(@PathVariable Long id) {
        return detallePedidoService.obtenerDetalle(id);
    }

    @PostMapping
    public DetallePedidoDTO crearDetalle(
            @Valid
            @RequestBody DetallePedidoDTO dto) {

        return detallePedidoService.crearDetalle(dto);

    }

    @PutMapping("/{id}")
    public DetallePedidoDTO actualizarDetalle(
            @PathVariable Long id,
            @Valid
            @RequestBody DetallePedidoDTO dto) {

        return detallePedidoService.actualizarDetalle(id, dto);

    }

    @DeleteMapping("/{id}")
    public void eliminarDetalle(@PathVariable Long id) {
        detallePedidoService.eliminarDetalle(id);
    }

}
