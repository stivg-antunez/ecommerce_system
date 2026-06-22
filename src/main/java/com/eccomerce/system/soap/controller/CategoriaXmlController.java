package com.eccomerce.system.soap.controller;

import com.eccomerce.system.dto.CategoriaDTO;
import com.eccomerce.system.service.CategoriaService;
import com.eccomerce.system.soap.response.ObtenerCategoriaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaXmlController {

    private final CategoriaService categoriaService;

    @GetMapping(
            value = "/xml/{id}",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public ObtenerCategoriaResponse obtenerCategoriaXml(
            @PathVariable Long id
    ) {

        CategoriaDTO categoria =
                categoriaService.obtenerCategoria(id);

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