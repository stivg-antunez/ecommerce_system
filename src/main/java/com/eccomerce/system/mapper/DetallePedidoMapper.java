package com.eccomerce.system.mapper;

import com.eccomerce.system.dto.DetallePedidoDTO;
import com.eccomerce.system.model.DetallePedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetallePedidoMapper {

    DetallePedidoDTO toDTO(DetallePedido detallePedido);

    DetallePedido toEntity(DetallePedidoDTO dto);

    List<DetallePedidoDTO> toDTOList(List<DetallePedido> detalles);

}