package com.example.demo.dto.response;

import lombok.Data;

@Data
public class BodegaResponse {
    private Long id;
    private String nombre;
    private Long idBodeguero;
    private String nombreBodeguero;
    private String ubicacion;
    private Boolean estado;
}