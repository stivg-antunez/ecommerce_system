package com.eccomerce.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3,max = 100)
    private String nombre;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 9,max = 15)
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}