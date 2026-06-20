package com.eccomerce.system.thread;

import com.eccomerce.system.model.DetallePedido;
import com.eccomerce.system.model.Pedido;
import com.eccomerce.system.repository.PedidoRepository;
import com.eccomerce.system.repository.ProductoRepository;
import com.eccomerce.system.socket.PedidoNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class PedidoExecutorService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final PedidoNotificationService notificationService;

    private final ExecutorService executor =
            Executors.newFixedThreadPool(5);

    public void procesarPedido(
            Pedido pedido
    ) {

        executor.submit(

                new PedidoProcessorTask(
                        pedido,
                        pedidoRepository,
                        notificationService
                )

        );

        if (pedido.getDetalles() != null) {

            for (DetallePedido detalle :
                    pedido.getDetalles()) {

                executor.submit(

                        new InventarioTask(
                                productoRepository,
                                detalle.getProducto().getId(),
                                detalle.getCantidad()
                        )

                );

            }

        }

    }

}