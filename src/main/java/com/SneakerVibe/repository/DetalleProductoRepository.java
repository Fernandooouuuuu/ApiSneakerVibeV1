package com.SneakerVibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SneakerVibe.model.DetalleProducto;

public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Long>{
    
}
