package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;

    @Column(nullable = false, length = 13)
    private String ruc;

    @Column(name = "nombre_comercial", nullable = false, length = 150)
    private String nombreComercial;

    @Column(name = "representante_legal", nullable = false, length = 150)
    private String representanteLegal;

    @Column(nullable = false)
    private Integer credito;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false)
    private Integer telefono;

    @Column(nullable = false)
    private Boolean estado;
}