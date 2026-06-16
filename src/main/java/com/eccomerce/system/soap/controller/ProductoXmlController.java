package com.eccomerce.system.soap.controller;

import com.eccomerce.system.dto.ProductoDTO;
import com.eccomerce.system.service.ProductoService;
import com.eccomerce.system.soap.response.ObtenerProductoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoXmlController {

    private final ProductoService productoService;

    @GetMapping(
            value = "/xml/{id}",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public ObtenerProductoResponse obtenerProductoXml(
            @PathVariable Long id
    ) {

        ProductoDTO producto =
                productoService.obtenerProducto(id);

        ObtenerProductoResponse response =
                new ObtenerProductoResponse();

        response.setId(producto.getId());
        response.setNombre(producto.getNombre());
        response.setDescripcion(producto.getDescripcion());
        response.setPrecio(producto.getPrecio());
        response.setStock(producto.getStock());

        return response;
    }
}
