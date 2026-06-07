package com.eccomerce.system.mapper;

import com.eccomerce.system.dto.ProductoDTO;
import com.eccomerce.system.model.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDTO toDTO(Producto producto);

    Producto toEntity(ProductoDTO dto);

    List<ProductoDTO> toDTOList(List<Producto> productos);

}