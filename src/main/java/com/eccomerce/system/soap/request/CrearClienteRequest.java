package com.eccomerce.system.soap.request;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "crearClienteRequest",
        namespace = "http://eccomerce.com/cliente"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class CrearClienteRequest {

    private String nombre;
    private String email;
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}