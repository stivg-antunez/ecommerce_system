package com.eccomerce.system.soap.response;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "crearClienteResponse",
        namespace = "http://eccomerce.com/cliente"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class CrearClienteResponse {

    private Long id;
    private String mensaje;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}