package com.eccomerce.system.service;

import com.eccomerce.system.dto.ClienteDTO;
import com.eccomerce.system.mapper.ClienteMapper;
import com.eccomerce.system.model.Cliente;
import com.eccomerce.system.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public List<ClienteDTO> listarClientes() {

        return clienteMapper.toDTOList(
                clienteRepository.findAll()
        );

    }

    public ClienteDTO obtenerCliente(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        return clienteMapper.toDTO(cliente);

    }

    public ClienteDTO crearCliente(ClienteDTO dto) {

        Cliente cliente = clienteMapper.toEntity(dto);

        return clienteMapper.toDTO(
                clienteRepository.save(cliente)
        );

    }

    public ClienteDTO actualizarCliente(Long id, ClienteDTO dto) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());

        return clienteMapper.toDTO(
                clienteRepository.save(cliente)
        );

    }

    public void eliminarCliente(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        clienteRepository.delete(cliente);

    }

}
