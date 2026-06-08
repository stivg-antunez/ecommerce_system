package com.eccomerce.system.thread;

import com.eccomerce.system.model.Producto;
import com.eccomerce.system.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InventarioTask implements Runnable {

    private final ProductoRepository productoRepository;
    private final Long productoId;
    private final Integer cantidad;

    @Override
    public void run() {

        Producto producto =
                productoRepository.findById(
                        productoId
                ).orElseThrow();

        producto.setStock(
                producto.getStock() - cantidad
        );

        productoRepository.save(
                producto
        );

        System.out.println(
                "Inventario actualizado"
        );

    }

}