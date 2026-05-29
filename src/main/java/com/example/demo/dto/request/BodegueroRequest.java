package com.example.demo.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BodegueroRequest {

    @NotBlank (message = "El campo no puede estar vacio")
    private String nombre;

    @NotBlank (message = "El campo no puede estar vacio")
    private String apellido;

    @NotNull(message = "El campo no puede estar vacio")
    private Boolean estado;

}
