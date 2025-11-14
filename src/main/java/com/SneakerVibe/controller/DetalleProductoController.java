package com.SneakerVibe.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.SneakerVibe.repository.DetalleProductoRepository;
import com.SneakerVibe.model.DetalleProducto;

@RestController
@RequestMapping("/api/detalle-productos")
@CrossOrigin(origins = "*")
public class DetalleProductoController {
    private final DetalleProductoRepository detalleProductoRepository;

    public DetalleProductoController(DetalleProductoRepository detalleProductoRepository) {
        this.detalleProductoRepository = detalleProductoRepository;
    }

    // obtener todos los detalles de productos
    @GetMapping
    public List<DetalleProducto> getAllDetalleProductos() {
        return detalleProductoRepository.findAll();
    }

    // obtener detalle de producto por id
    @GetMapping("/{id}")
    public DetalleProducto getDetalleProductoById(@PathVariable Long id) {
        return detalleProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleProducto no encontrado con id: " + id));
    }

    // crear nuevo detalle de producto
    @PostMapping
    public DetalleProducto createDetalleProducto(@RequestBody DetalleProducto detalleProducto) {
        return detalleProductoRepository.save(detalleProducto);
    }

    // actualizar detalle de producto
    @PutMapping("/{id}")
    public DetalleProducto updateDetalleProducto(@PathVariable Long id,
            @RequestBody DetalleProducto detalleProductoDetails) {
        DetalleProducto detalleProducto = detalleProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleProducto no encontrado con id: " + id));

        detalleProducto.setTalla(detalleProductoDetails.getTalla());
        detalleProducto.setColor(detalleProductoDetails.getColor());
        detalleProducto.setStock(detalleProductoDetails.getStock());
        detalleProducto.setProducto(detalleProductoDetails.getProducto());

        return detalleProductoRepository.save(detalleProducto);
    }

    // eliminar detalle de producto
    @DeleteMapping("/{id}")
    public void deleteDetalleProducto(@PathVariable Long id) {
        DetalleProducto detalleProducto = detalleProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleProducto no encontrado con id: " + id));
        detalleProductoRepository.delete(detalleProducto);
    }
}
