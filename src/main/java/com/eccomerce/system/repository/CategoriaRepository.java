package com.eccomerce.system.repository;

import com.eccomerce.system.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {
}