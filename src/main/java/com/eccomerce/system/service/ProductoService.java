package com.eccomerce.system.service;

import com.eccomerce.system.dto.ProductoDTO;
import com.eccomerce.system.mapper.ProductoMapper;
import com.eccomerce.system.model.Producto;
import com.eccomerce.system.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public List<ProductoDTO> listarProductos() {

        return productoMapper.toDTOList(
                productoRepository.findAll()
        );

    }

    public ProductoDTO obtenerProducto(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));

        return productoMapper.toDTO(producto);

    }

    public ProductoDTO crearProducto(ProductoDTO dto) {

        Producto producto = productoMapper.toEntity(dto);

        return productoMapper.toDTO(
                productoRepository.save(producto)
        );

    }

    public ProductoDTO actualizarProducto(Long id,
                                          ProductoDTO dto) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));

        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());

        return productoMapper.toDTO(
                productoRepository.save(producto)
        );

    }

    public void eliminarProducto(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));

        productoRepository.delete(producto);

    }

}