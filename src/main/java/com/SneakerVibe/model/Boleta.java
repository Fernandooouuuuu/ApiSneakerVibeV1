package com.SneakerVibe.model;

import java.time.*;
import java.util.List;
import java.math.BigDecimal;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "boleta")
@NoArgsConstructor
@AllArgsConstructor
public class Boleta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal total;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "boleta", cascade = CascadeType.ALL)
    private List<BoletaItem> items;

}
