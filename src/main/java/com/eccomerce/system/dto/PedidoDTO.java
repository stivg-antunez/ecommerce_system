package com.eccomerce.system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

    private Long id;
    private String cliente;
    private Double total;
    private String estado;

}