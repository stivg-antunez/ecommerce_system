package com.eccomerce.system.thread;

import com.eccomerce.system.model.EstadoPedido;
import com.eccomerce.system.model.Pedido;
import com.eccomerce.system.repository.PedidoRepository;
import com.eccomerce.system.socket.PedidoNotificationService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PedidoProcessorTask implements Runnable {

    private final Pedido pedido;
    private final PedidoRepository pedidoRepository;
    private final PedidoNotificationService notificationService;

    @Override
    public void run() {

        try {

            System.out.println(
                    "Procesando pedido "
                            + pedido.getId()
                            + " en "
                            + Thread.currentThread().getName()
            );

            Thread.sleep(5000);

            pedido.setEstado(
                    EstadoPedido.PROCESANDO
            );

            pedidoRepository.save(
                    pedido
            );

            notificationService.actualizarPedido(
                    pedido.getId(),
                    pedido.getEstado().name()
            );

            System.out.println(
                    "Pedido "
                            + pedido.getId()
                            + " actualizado a "
                            + pedido.getEstado()
            );

        } catch (Exception e) {

            System.err.println(
                    "Error procesando pedido "
                            + pedido.getId()
            );

            e.printStackTrace();

        }

    }

}