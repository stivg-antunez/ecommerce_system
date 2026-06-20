package com.eccomerce.system.controller;

import com.eccomerce.system.dto.ProductoDTO;
import com.eccomerce.system.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductoDTO> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoDTO obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProducto(id);
    }

    @PostMapping
    public ProductoDTO crearProducto(
            @Valid
            @RequestBody ProductoDTO dto) {

        return productoService.crearProducto(dto);

    }

    @PutMapping("/{id}")
    public ProductoDTO actualizarProducto(
            @PathVariable Long id,
            @Valid
            @RequestBody ProductoDTO dto) {

        return productoService.actualizarProducto(id, dto);

    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

}