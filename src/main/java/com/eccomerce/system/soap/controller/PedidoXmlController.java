package com.eccomerce.system.soap.controller;

import com.eccomerce.system.dto.PedidoDTO;
import com.eccomerce.system.service.PedidoService;
import com.eccomerce.system.soap.response.ObtenerPedidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoXmlController {

    private final PedidoService pedidoService;

    @GetMapping(
            value = "/xml/{id}",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public ObtenerPedidoResponse obtenerPedidoXml(
            @PathVariable Long id
    ) {

        PedidoDTO pedido =
                pedidoService.obtenerPedido(id);

        ObtenerPedidoResponse response =
                new ObtenerPedidoResponse();

        response.setId(pedido.getId());
        response.setCliente(pedido.getCliente());
        response.setEstado(pedido.getEstado());
        response.setTotal(pedido.getTotal());

        return response;
    }
}
