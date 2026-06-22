package com.eccomerce.system.soap.response;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "obtenerCategoriaResponse",
        namespace = "http://eccomerce.com/categoria"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ObtenerCategoriaResponse {

    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}