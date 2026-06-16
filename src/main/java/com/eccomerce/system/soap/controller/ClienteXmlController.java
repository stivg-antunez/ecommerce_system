package com.eccomerce.system.soap.controller;

import com.eccomerce.system.dto.ClienteDTO;
import com.eccomerce.system.service.ClienteService;
import com.eccomerce.system.soap.response.ObtenerClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteXmlController {

    private final ClienteService clienteService;

    @GetMapping(
            value = "/xml/{id}",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public ObtenerClienteResponse obtenerClienteXml(
            @PathVariable Long id
    ) {

        ClienteDTO cliente =
                clienteService.obtenerCliente(id);

        ObtenerClienteResponse response =
                new ObtenerClienteResponse();

        response.setId(cliente.getId());
        response.setNombre(cliente.getNombre());
        response.setEmail(cliente.getEmail());
        response.setTelefono(cliente.getTelefono());

        return response;
    }
}