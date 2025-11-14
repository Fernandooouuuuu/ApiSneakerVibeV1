package com.SneakerVibe.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.SneakerVibe.repository.CarritoRepository;
import com.SneakerVibe.model.Carrito;

@RestController
@RequestMapping("/api/carritos")
@CrossOrigin(origins = "*")
public class CarritoController {
    private final CarritoRepository carritoRepository;

    public CarritoController(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    // obtener todos los carritos
    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }

    // obtener carrito por id
    @GetMapping("/{id}")
    public Carrito getCarritoById(@PathVariable Long id) {
        return carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado con id: " + id));
    }

    // crear nuevo carrito
    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    // actualizar carrito
    @PutMapping("/{id}")
    public Carrito updateCarrito(@PathVariable Long id, @RequestBody Carrito carrito) {
        Carrito existingCarrito = carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado con id: " + id));

        existingCarrito.setEstado(carrito.getEstado());
        existingCarrito.setUsuario(carrito.getUsuario());
        existingCarrito.setItems(carrito.getItems());

        return carritoRepository.save(existingCarrito);
    }

    // eliminar carrito
    @DeleteMapping("/{id}")
    public void deleteCarrito(@PathVariable Long id) {
        Carrito carrito = carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado con id: " + id));
        carritoRepository.delete(carrito);
    }
}
