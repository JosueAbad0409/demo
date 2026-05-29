package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProveedorRequest {

    @NotBlank(message = "El RUC no puede estar vacío")
    private String ruc;

    @NotBlank(message = "El nombre comercial no puede estar vacío")
    private String nombreComercial;

    @NotBlank(message = "El representante legal no puede estar vacío")
    private String representanteLegal;

    @NotNull(message = "El crédito no puede estar vacío")
    private Integer credito;

    @NotBlank(message = "La dirección no puede estar vacía")
    private String direccion;

    @NotNull(message = "El teléfono no puede estar vacío")
    private Integer telefono;

    @NotNull(message = "El estado no puede estar vacío")
    private Boolean estado;
}