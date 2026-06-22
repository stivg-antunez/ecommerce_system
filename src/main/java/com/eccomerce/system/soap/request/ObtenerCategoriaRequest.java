package com.eccomerce.system.soap.request;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "obtenerCategoriaRequest",
        namespace = "http://eccomerce.com/categoria"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ObtenerCategoriaRequest {

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