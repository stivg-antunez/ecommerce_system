package com.eccomerce.system.service;

import com.eccomerce.system.dto.ProductoDTO;
import com.eccomerce.system.mapper.ProductoMapper;
import com.eccomerce.system.model.Categoria;
import com.eccomerce.system.model.Producto;
import com.eccomerce.system.repository.CategoriaRepository;
import com.eccomerce.system.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;
    private final CategoriaRepository categoriaRepository;

    public List<ProductoDTO> listarProductos() {

        return productoMapper.toDTOList(
                productoRepository.findAll()
        );

    }

    public ProductoDTO obtenerProducto(Long id) {

        Producto producto =
                productoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Producto no encontrado"
                                ));

        ProductoDTO dto =
                productoMapper.toDTO(
                        producto
                );

        if (producto.getCategoria() != null) {

            dto.setCategoriaId(
                    producto.getCategoria().getId()
            );

            dto.setCategoriaNombre(
                    producto.getCategoria().getNombre()
            );

        }

        return dto;

    }

    public ProductoDTO crearProducto(
            ProductoDTO dto
    ) {

        Categoria categoria =
                categoriaRepository.findById(
                        dto.getCategoriaId()
                ).orElseThrow();

        Producto producto =
                Producto.builder()
                        .nombre(dto.getNombre())
                        .descripcion(dto.getDescripcion())
                        .precio(dto.getPrecio())
                        .stock(dto.getStock())
                        .categoria(categoria)
                        .build();

        producto =
                productoRepository.save(producto);

        ProductoDTO response =
                productoMapper.toDTO(producto);

        response.setCategoriaId(
                categoria.getId()
        );

        response.setCategoriaNombre(
                categoria.getNombre()
        );

        return response;

    }

    public ProductoDTO actualizarProducto(
            Long id,
            ProductoDTO dto
    ) {

        Producto producto =
                productoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Producto no encontrado"
                                ));

        Categoria categoria =
                categoriaRepository.findById(
                        dto.getCategoriaId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Categoria no encontrada"
                        ));

        producto.setNombre(
                dto.getNombre()
        );

        producto.setDescripcion(
                dto.getDescripcion()
        );

        producto.setPrecio(
                dto.getPrecio()
        );

        producto.setStock(
                dto.getStock()
        );

        producto.setCategoria(
                categoria
        );

        producto =
                productoRepository.save(
                        producto
                );

        ProductoDTO response =
                productoMapper.toDTO(
                        producto
                );

        response.setCategoriaId(
                categoria.getId()
        );

        response.setCategoriaNombre(
                categoria.getNombre()
        );

        return response;

    }

    public void eliminarProducto(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));

        productoRepository.delete(producto);

    }

}