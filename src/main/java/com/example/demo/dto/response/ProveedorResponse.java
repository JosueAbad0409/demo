package com.example.demo.dto.response;

import lombok.Data;

@Data
public class ProveedorResponse {
    private Long id;
    private String ruc;
    private String nombreComercial;
    private String representanteLegal;
    private Integer credito;
    private String direccion;
    private Integer telefono;
    private Boolean estado;
}