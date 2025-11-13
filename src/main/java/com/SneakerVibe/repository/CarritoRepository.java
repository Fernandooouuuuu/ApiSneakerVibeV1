package com.SneakerVibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SneakerVibe.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{
    
}
