package com.eccomerce.system.soap.request;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "obtenerProductoRequest",
        namespace = "http://eccomerce.com/producto"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ObtenerProductoRequest {

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