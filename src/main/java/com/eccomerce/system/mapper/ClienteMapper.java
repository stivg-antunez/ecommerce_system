package com.eccomerce.system.mapper;

import com.eccomerce.system.dto.ClienteDTO;
import com.eccomerce.system.model.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDTO toDTO(Cliente cliente);

    Cliente toEntity(ClienteDTO dto);

    List<ClienteDTO> toDTOList(List<Cliente> clientes);

}