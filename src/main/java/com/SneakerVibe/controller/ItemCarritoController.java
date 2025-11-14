package com.SneakerVibe.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.SneakerVibe.repository.ItemCarritoRepository;
import com.SneakerVibe.model.ItemCarrito;

@RestController
@RequestMapping("/api/item-carritos")
@CrossOrigin(origins = "*")
public class ItemCarritoController {
    private final ItemCarritoRepository itemCarritoRepository;

    public ItemCarritoController(ItemCarritoRepository itemCarritoRepository) {
        this.itemCarritoRepository = itemCarritoRepository;
    }

    // obtener todos los items de carrito
    @GetMapping
    public List<ItemCarrito> getAllItemCarritos() {
        return itemCarritoRepository.findAll();
    }

    // obtener item de carrito por id
    @GetMapping("/{id}")
    public ItemCarrito getItemCarritoById(@PathVariable Long id) {
        return itemCarritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemCarrito no encontrado con id: " + id));
    }

    // crear nuevo item de carrito
    @PostMapping
    public ItemCarrito createItemCarrito(@RequestBody ItemCarrito itemCarrito) {
        return itemCarritoRepository.save(itemCarrito);
    }

    // actualizar item de carrito
    @PutMapping("/{id}")
    public ItemCarrito updateItemCarrito(@PathVariable Long id, @RequestBody ItemCarrito itemCarritoDetails) {
        ItemCarrito itemCarrito = itemCarritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemCarrito no encontrado con id: " + id));

        itemCarrito.setCantidad(itemCarritoDetails.getCantidad());
        itemCarrito.setDetalleProducto(itemCarritoDetails.getDetalleProducto());
        itemCarrito.setCarrito(itemCarritoDetails.getCarrito());

        return itemCarritoRepository.save(itemCarrito);
    }

    // eliminar item de carrito
    @DeleteMapping("/{id}")
    public void deleteItemCarrito(@PathVariable Long id) {
        ItemCarrito itemCarrito = itemCarritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemCarrito no encontrado con id: " + id));
        itemCarritoRepository.delete(itemCarrito);
    }

}
