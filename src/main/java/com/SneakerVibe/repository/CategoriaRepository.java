package com.SneakerVibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SneakerVibe.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
