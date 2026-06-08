package com.eccomerce.system.soap.endpoint;

import com.eccomerce.system.dto.PedidoDTO;
import com.eccomerce.system.service.PedidoService;
import com.eccomerce.system.soap.request.ObtenerPedidoRequest;
import com.eccomerce.system.soap.response.ObtenerPedidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
@RequiredArgsConstructor
public class PedidoEndpoint {

    private static final String NAMESPACE =
            "http://eccomerce.com/pedido";

    private final PedidoService pedidoService;

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "obtenerPedidoRequest"
    )
    @ResponsePayload
    public ObtenerPedidoResponse obtenerPedido(
            @RequestPayload
            ObtenerPedidoRequest request
    ) {

        System.out.println(
                "ID RECIBIDO = " +
                        request.getId()
        );

        PedidoDTO pedido =
                pedidoService.obtenerPedido(
                        request.getId()
                );

        ObtenerPedidoResponse response =
                new ObtenerPedidoResponse();

        response.setId(
                pedido.getId()
        );

        response.setCliente(
                pedido.getCliente()
        );

        response.setEstado(
                pedido.getEstado()
        );

        response.setTotal(
                pedido.getTotal()
        );

        return response;
    }

}