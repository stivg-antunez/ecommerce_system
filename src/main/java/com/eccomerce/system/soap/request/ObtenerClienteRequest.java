package com.eccomerce.system.soap.request;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "obtenerClienteRequest",
        namespace = "http://eccomerce.com/cliente"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ObtenerClienteRequest {

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