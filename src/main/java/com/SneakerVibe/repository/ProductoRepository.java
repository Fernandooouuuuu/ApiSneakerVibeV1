package com.SneakerVibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SneakerVibe.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
