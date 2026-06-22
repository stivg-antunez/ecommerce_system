package com.eccomerce.system.service;

import com.eccomerce.system.dto.CategoriaDTO;
import com.eccomerce.system.mapper.CategoriaMapper;
import com.eccomerce.system.model.Categoria;
import com.eccomerce.system.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> listarCategorias() {

        return categoriaMapper.toDTOList(
                categoriaRepository.findAll()
        );

    }

    public CategoriaDTO obtenerCategoria(Long id) {

        Categoria categoria =
                categoriaRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Categoria no encontrada"
                                ));

        return categoriaMapper.toDTO(categoria);

    }

    public CategoriaDTO crearCategoria(
            CategoriaDTO dto
    ) {

        Categoria categoria =
                categoriaMapper.toEntity(dto);

        return categoriaMapper.toDTO(
                categoriaRepository.save(categoria)
        );

    }

    public CategoriaDTO actualizarCategoria(
            Long id,
            CategoriaDTO dto
    ) {

        Categoria categoria =
                categoriaRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Categoria no encontrada"
                                ));

        categoria.setNombre(
                dto.getNombre()
        );

        return categoriaMapper.toDTO(
                categoriaRepository.save(categoria)
        );

    }

    public void eliminarCategoria(Long id) {

        categoriaRepository.deleteById(id);

    }

}