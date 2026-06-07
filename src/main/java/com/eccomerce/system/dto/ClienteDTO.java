package com.eccomerce.system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;

}