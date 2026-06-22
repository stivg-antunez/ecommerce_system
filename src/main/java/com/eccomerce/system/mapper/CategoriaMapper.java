package com.eccomerce.system.mapper;

import com.eccomerce.system.dto.CategoriaDTO;
import com.eccomerce.system.model.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDTO toDTO(Categoria categoria);

    Categoria toEntity(CategoriaDTO dto);

    List<CategoriaDTO> toDTOList(
            List<Categoria> categorias
    );

}