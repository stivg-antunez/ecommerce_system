package com.eccomerce.system.soap.endpoint;

import com.eccomerce.system.dto.ClienteDTO;
import com.eccomerce.system.service.ClienteService;
import com.eccomerce.system.soap.request.ObtenerClienteRequest;
import com.eccomerce.system.soap.response.ObtenerClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
@RequiredArgsConstructor
public class ClienteEndpoint {

    private static final String NAMESPACE =
            "http://eccomerce.com/cliente";

    private final ClienteService clienteService;

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "obtenerClienteRequest"
    )
    @ResponsePayload
    public ObtenerClienteResponse obtenerCliente(
            @RequestPayload
            ObtenerClienteRequest request
    ) {

        ClienteDTO cliente =
                clienteService.obtenerCliente(
                        request.getId()
                );

        ObtenerClienteResponse response =
                new ObtenerClienteResponse();

        response.setId(cliente.getId());
        response.setNombre(cliente.getNombre());
        response.setEmail(cliente.getEmail());
        response.setTelefono(cliente.getTelefono());

        return response;
    }
}