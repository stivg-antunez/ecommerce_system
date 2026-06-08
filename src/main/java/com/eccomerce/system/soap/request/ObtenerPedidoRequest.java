package com.eccomerce.system.soap.request;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "obtenerPedidoRequest",
        namespace = "http://eccomerce.com/pedido"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ObtenerPedidoRequest {

    @XmlElement(
            name = "id",
            required = true
    )
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}