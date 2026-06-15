package com.eccomerce.system.soap.endpoint;

import com.eccomerce.system.dto.ProductoDTO;
import com.eccomerce.system.service.ProductoService;
import com.eccomerce.system.soap.request.ObtenerProductoRequest;
import com.eccomerce.system.soap.response.ObtenerProductoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
@RequiredArgsConstructor
public class ProductoEndpoint {

    private static final String NAMESPACE =
            "http://eccomerce.com/producto";

    private final ProductoService productoService;

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "obtenerProductoRequest"
    )
    @ResponsePayload
    public ObtenerProductoResponse obtenerProducto(
            @RequestPayload
            ObtenerProductoRequest request
    ) {

        ProductoDTO producto =
                productoService.obtenerProducto(
                        request.getId()
                );

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