package com.SneakerVibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SneakerVibe.model.ItemCarrito;

public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long>{
    
}
