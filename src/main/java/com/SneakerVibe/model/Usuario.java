package com.SneakerVibe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contrasena;
    private String direccion;
    
    @Column(name =  "nro_domicio")
    private String numDomicilio;
    private String region;
    private String comuna;

    @Column(nullable = false)
    private Boolean esAdmin;
}
   
