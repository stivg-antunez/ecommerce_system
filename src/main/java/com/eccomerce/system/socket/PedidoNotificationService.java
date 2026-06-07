package com.eccomerce.system.socket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoNotificationService {

    private final PedidoSocketServer socketServer;

    public void nuevoPedido(Long id, Double total) {

        socketServer.enviarATodos(
                """
                ==========================
                NUEVO PEDIDO
                ID: %d
                TOTAL: %.2f
                ==========================
                """.formatted(id, total)
        );

    }

    public void actualizarPedido(Long id, String estado) {

        socketServer.enviarATodos(
                """
                ==========================
                PEDIDO ACTUALIZADO
                ID: %d
                ESTADO: %s
                ==========================
                """.formatted(id, estado)
        );

    }

}