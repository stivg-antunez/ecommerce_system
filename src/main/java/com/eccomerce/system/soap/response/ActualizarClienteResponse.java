package com.eccomerce.system.soap.response;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "actualizarClienteResponse",
        namespace = "http://eccomerce.com/cliente"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ActualizarClienteResponse {

    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}