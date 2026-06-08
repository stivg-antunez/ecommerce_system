package com.eccomerce.system.soap.response;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(
        name = "obtenerPedidoResponse",
        namespace = "http://eccomerce.com/pedido"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ObtenerPedidoResponse {

    private Long id;
    private String cliente;
    private String estado;
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}