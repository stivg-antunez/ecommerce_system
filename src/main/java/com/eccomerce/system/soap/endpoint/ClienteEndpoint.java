package com.eccomerce.system.soap.endpoint;

import com.eccomerce.system.dto.ClienteDTO;
import com.eccomerce.system.service.ClienteService;
import com.eccomerce.system.soap.request.ActualizarClienteRequest;
import com.eccomerce.system.soap.request.CrearClienteRequest;
import com.eccomerce.system.soap.request.EliminarClienteRequest;
import com.eccomerce.system.soap.request.ObtenerClienteRequest;
import com.eccomerce.system.soap.response.ActualizarClienteResponse;
import com.eccomerce.system.soap.response.CrearClienteResponse;
import com.eccomerce.system.soap.response.EliminarClienteResponse;
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

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "crearClienteRequest"
    )
    @ResponsePayload
    public CrearClienteResponse crearCliente(
            @RequestPayload CrearClienteRequest request
    ) {

        ClienteDTO dto = new ClienteDTO();

        dto.setNombre(request.getNombre());
        dto.setEmail(request.getEmail());
        dto.setTelefono(request.getTelefono());

        ClienteDTO clienteCreado =
                clienteService.crearCliente(dto);

        CrearClienteResponse response =
                new CrearClienteResponse();

        response.setId(clienteCreado.getId());
        response.setMensaje("Cliente creado correctamente");

        return response;
    }

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "actualizarClienteRequest"
    )
    @ResponsePayload
    public ActualizarClienteResponse actualizarCliente(
            @RequestPayload ActualizarClienteRequest request
    ) {

        ClienteDTO dto = new ClienteDTO();

        dto.setNombre(request.getNombre());
        dto.setEmail(request.getEmail());
        dto.setTelefono(request.getTelefono());

        clienteService.actualizarCliente(
                request.getId(),
                dto
        );

        ActualizarClienteResponse response =
                new ActualizarClienteResponse();

        response.setMensaje(
                "Cliente actualizado correctamente"
        );

        return response;
    }

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "eliminarClienteRequest"
    )
    @ResponsePayload
    public EliminarClienteResponse eliminarCliente(
            @RequestPayload EliminarClienteRequest request
    ) {

        clienteService.eliminarCliente(
                request.getId()
        );

        EliminarClienteResponse response =
                new EliminarClienteResponse();

        response.setMensaje(
                "Cliente eliminado correctamente"
        );

        return response;
    }
}