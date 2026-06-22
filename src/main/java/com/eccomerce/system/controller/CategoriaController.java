package com.eccomerce.system.controller;

import com.eccomerce.system.dto.CategoriaDTO;
import com.eccomerce.system.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaDTO obtenerCategoria(
            @PathVariable Long id
    ) {
        return categoriaService.obtenerCategoria(id);
    }

    @PostMapping
    public CategoriaDTO crearCategoria(
            @Valid
            @RequestBody CategoriaDTO dto
    ) {
        return categoriaService.crearCategoria(dto);
    }

    @PutMapping("/{id}")
    public CategoriaDTO actualizarCategoria(
            @PathVariable Long id,
            @RequestBody CategoriaDTO dto
    ) {
        return categoriaService.actualizarCategoria(
                id,
                dto
        );
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(
            @PathVariable Long id
    ) {
        categoriaService.eliminarCategoria(id);
    }

}