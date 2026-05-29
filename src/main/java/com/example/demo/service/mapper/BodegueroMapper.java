package com.example.demo.service.mapper;


import com.example.demo.dto.request.BodegueroRequest;
import com.example.demo.dto.response.BodegueroResponse;
import com.example.demo.model.Bodeguero;
import org.springframework.stereotype.Component;

@Component
public class BodegueroMapper {

    public Bodeguero toEntity(BodegueroRequest request){
        Bodeguero bodeguero = new Bodeguero();
        bodeguero.setNombre(request.getNombre());
        bodeguero.setApellido(request.getApellido());
        bodeguero.setEstado(request.getEstado());
        return bodeguero;
    }

    public BodegueroResponse toResponseDto(Bodeguero bodeguero){
        BodegueroResponse response = new BodegueroResponse();
        response.setId(bodeguero.getId());
        response.setNombre(bodeguero.getNombre());
        response.setApellido(bodeguero.getApellido());
        response.setEstado(bodeguero.getEstado());
        return response;
    }
}
