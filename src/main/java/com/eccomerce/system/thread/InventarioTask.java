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

        try {

            Producto producto =
                    productoRepository.findById(
                            productoId
                    ).orElseThrow(
                            () -> new RuntimeException(
                                    "Producto no encontrado"
                            )
                    );

            Integer stockAnterior =
                    producto.getStock();

            producto.setStock(
                    stockAnterior - cantidad
            );

            productoRepository.save(
                    producto
            );

            System.out.println(
                    "Inventario actualizado -> Producto: "
                            + productoId
                            + " | Stock anterior: "
                            + stockAnterior
                            + " | Nuevo stock: "
                            + producto.getStock()
                            + " | Hilo: "
                            + Thread.currentThread().getName()
            );

        } catch (Exception e) {

            System.err.println(
                    "Error actualizando inventario"
            );

            e.printStackTrace();

        }

    }

}