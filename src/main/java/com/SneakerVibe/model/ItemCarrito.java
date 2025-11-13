package com.SneakerVibe.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "item_carrito")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCarrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "carrito_id", nullable = false)
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "detalle_producto_id", nullable = false)
    private DetalleProducto detalleProducto;
}
