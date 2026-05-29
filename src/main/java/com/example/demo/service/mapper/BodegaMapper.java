package com.example.demo.service.mapper;

import com.example.demo.dto.request.BodegaRequest;
import com.example.demo.dto.response.BodegaResponse;
import com.example.demo.model.Bodega;
import com.example.demo.model.Bodeguero;
import org.springframework.stereotype.Component;

@Component
public class BodegaMapper {

    public Bodega toEntity(BodegaRequest request, Bodeguero bodeguero) {
        Bodega bodega = new Bodega();
        bodega.setNombre(request.getNombre());
        bodega.setUbicacion(request.getUbicacion());
        bodega.setEstado(request.getEstado());
        bodega.setBodeguero(bodeguero);
        return bodega;
    }

    public BodegaResponse toResponseDto(Bodega bodega) {
        BodegaResponse response = new BodegaResponse();
        response.setId(bodega.getId());
        response.setNombre(bodega.getNombre());
        response.setUbicacion(bodega.getUbicacion());
        response.setEstado(bodega.getEstado());

        if (bodega.getBodeguero() != null) {
            response.setIdBodeguero(bodega.getBodeguero().getId());
            response.setNombreBodeguero(bodega.getBodeguero().getNombre() + " " + bodega.getBodeguero().getApellido());
        }
        return response;
    }
}