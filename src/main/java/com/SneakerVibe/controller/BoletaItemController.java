package com.SneakerVibe.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.SneakerVibe.repository.BoletaItemRepository;
import com.SneakerVibe.model.BoletaItem;

@RestController
@RequestMapping("/api/boleta-items")
@CrossOrigin(origins = "*")
public class BoletaItemController {

    private final BoletaItemRepository boletaItemRepository;

    public BoletaItemController(BoletaItemRepository boletaItemRepository) {
        this.boletaItemRepository = boletaItemRepository;
    }

    // obtener todos los items de boleta
    @GetMapping
    public List<BoletaItem> getAllBoletaItems() {
        return boletaItemRepository.findAll();
    }

    // obtener item de boleta por id
    @GetMapping("/{id}")
    public BoletaItem getBoletaItemById(@PathVariable Long id) {
        return boletaItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BoletaItem no encontrado con id: " + id));
    }

    // crear nuevo item de boleta
    @PostMapping
    public BoletaItem createBoletaItem(@RequestBody BoletaItem boletaItem) {
        return boletaItemRepository.save(boletaItem);
    }

    // actualizar item de boleta
    @PutMapping("/{id}")
    public BoletaItem updateBoletaItem(@PathVariable Long id, @RequestBody BoletaItem boletaItemDetails) {
        BoletaItem boletaItem = boletaItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BoletaItem no encontrado con id: " + id));

        boletaItem.setCantidad(boletaItemDetails.getCantidad());
        boletaItem.setPrecioUnitario(boletaItemDetails.getPrecioUnitario());
        boletaItem.setBoleta(boletaItemDetails.getBoleta());
        boletaItem.setDetalleProducto(boletaItemDetails.getDetalleProducto());

        return boletaItemRepository.save(boletaItem);
    }

    // eliminar item de boleta
    @DeleteMapping("/{id}")
    public void deleteBoletaItem(@PathVariable Long id) {
        BoletaItem boletaItem = boletaItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BoletaItem no encontrado con id: " + id));
        boletaItemRepository.delete(boletaItem);
    }
}