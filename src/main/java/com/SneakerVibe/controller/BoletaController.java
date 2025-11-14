package com.SneakerVibe.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.SneakerVibe.repository.BoletaRepository;
import com.SneakerVibe.model.Boleta;

@RestController
@RequestMapping("/api/boletas")
@CrossOrigin(origins = "*")
public class BoletaController {
    private final BoletaRepository boletaRepository;

    public BoletaController(BoletaRepository boletaRepository) {
        this.boletaRepository = boletaRepository;
    }

    // obtener todas las boletas
    @GetMapping
    public List<Boleta> getAllBoletas() {
        return boletaRepository.findAll();
    }

    // obtener boleta por id
    @GetMapping("/{id}")
    public Boleta getBoletaById(@PathVariable Long id) {
        return boletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Boleta no encontrada con id: " + id));
    }

    // crear nueva boleta
    @PostMapping
    public Boleta createBoleta(@RequestBody Boleta boleta) {
        return boletaRepository.save(boleta);
    }

    // actualizar boleta
    @PutMapping("/{id}")
    public Boleta updateBoleta(@PathVariable Long id, @RequestBody Boleta boletaDetails) {
        Boleta boleta = boletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Boleta no encontrada con id: " + id));

        boleta.setTotal(boletaDetails.getTotal());
        boleta.setFecha(boletaDetails.getFecha());
        boleta.setUsuario(boletaDetails.getUsuario());
        boleta.setItems(boletaDetails.getItems());

        return boletaRepository.save(boleta);
    }

    // eliminar boleta
    @DeleteMapping("/{id}")
    public void deleteBoleta(@PathVariable Long id) {
        Boleta boleta = boletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Boleta no encontrada con id: " + id));
        boletaRepository.delete(boleta);
    }
}
