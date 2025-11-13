package com.SneakerVibe.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "boleta_item")
@NoArgsConstructor
@AllArgsConstructor
public class BoletaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer Cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "boleta_id", nullable = false)
    private Boleta boleta;

    @ManyToOne
    @JoinColumn(name = "detalle_producto_id", nullable = false)
    private DetalleProducto detalleProducto;
}
