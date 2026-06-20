package com.eccomerce.system.controller;

import com.eccomerce.system.dto.ClienteDTO;
import com.eccomerce.system.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerCliente(id);
    }

    @PostMapping
    public ClienteDTO crearCliente(
            @Valid
            @RequestBody ClienteDTO dto) {

        return clienteService.crearCliente(dto);

    }

    @PutMapping("/{id}")
    public ClienteDTO actualizarCliente(
            @PathVariable Long id,
            @Valid
            @RequestBody ClienteDTO dto) {

        return clienteService.actualizarCliente(id, dto);

    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }

}