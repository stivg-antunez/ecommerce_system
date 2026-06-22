package com.eccomerce.system.soap.request;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "eliminarClienteRequest",
        namespace = "http://eccomerce.com/cliente"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class EliminarClienteRequest {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}