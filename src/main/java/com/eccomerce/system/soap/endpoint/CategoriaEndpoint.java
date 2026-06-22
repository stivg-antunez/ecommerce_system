package com.eccomerce.system.soap.endpoint;

import com.eccomerce.system.dto.CategoriaDTO;
import com.eccomerce.system.service.CategoriaService;
import com.eccomerce.system.soap.request.ObtenerCategoriaRequest;
import com.eccomerce.system.soap.response.ObtenerCategoriaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
@RequiredArgsConstructor
public class CategoriaEndpoint {

    private static final String NAMESPACE =
            "http://eccomerce.com/categoria";

    private final CategoriaService categoriaService;

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "obtenerCategoriaRequest"
    )
    @ResponsePayload
    public ObtenerCategoriaResponse obtenerCategoria(
            @RequestPayload
            ObtenerCategoriaRequest request
    ) {

        CategoriaDTO categoria =
                categoriaService.obtenerCategoria(
                        request.getId()
                );

        ObtenerCategoriaResponse response =
                new ObtenerCategoriaResponse();

        response.setId(
                categoria.getId()
        );

        response.setNombre(
                categoria.getNombre()
        );

        return response;

    }

}