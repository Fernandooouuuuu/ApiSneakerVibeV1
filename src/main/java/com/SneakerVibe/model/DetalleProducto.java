package com.SneakerVibe.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "detalle_producto")
@NoArgsConstructor
@AllArgsConstructor
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String color;
    private String talla;

    private BigDecimal precio;

    private Integer stock;

    private String imgSrc;
    private String href;
    private String altText;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}

