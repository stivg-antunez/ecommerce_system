package com.eccomerce.system.soap.response;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "eliminarClienteResponse",
        namespace = "http://eccomerce.com/cliente"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class EliminarClienteResponse {

    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}