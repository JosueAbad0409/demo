package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BodegaRequest {

    @NotBlank(message = "El nombre de la bodega no puede estar vacío")
    private String nombre;

    @NotNull(message = "Debe asignar un bodeguero válido")
    private Long idBodeguero;

    @NotBlank(message = "La ubicación no puede estar vacía")
    private String ubicacion;

    @NotNull(message = "El estado no puede estar vacío")
    private Boolean estado;
}