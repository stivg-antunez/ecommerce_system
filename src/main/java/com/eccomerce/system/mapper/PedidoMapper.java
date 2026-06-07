package com.eccomerce.system.mapper;

import com.eccomerce.system.dto.PedidoDTO;
import com.eccomerce.system.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(source = "cliente.nombre", target = "cliente")
    PedidoDTO toDTO(Pedido pedido);

    List<PedidoDTO> toDTOList(List<Pedido> pedidos);

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "detalles", ignore = true)
    Pedido toEntity(PedidoDTO dto);

}