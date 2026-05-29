package com.example.demo.service.mapper;

import com.example.demo.dto.request.ProveedorRequest;
import com.example.demo.dto.response.ProveedorResponse;
import com.example.demo.model.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {

    public Proveedor toEntity(ProveedorRequest request) {
        Proveedor proveedor = new Proveedor();
        proveedor.setRuc(request.getRuc());
        proveedor.setNombreComercial(request.getNombreComercial());
        proveedor.setRepresentanteLegal(request.getRepresentanteLegal());
        proveedor.setCredito(request.getCredito());
        proveedor.setDireccion(request.getDireccion());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setEstado(request.getEstado());
        return proveedor;
    }

    public ProveedorResponse toResponseDto(Proveedor proveedor) {
        ProveedorResponse response = new ProveedorResponse();
        response.setId(proveedor.getId());
        response.setRuc(proveedor.getRuc());
        response.setNombreComercial(proveedor.getNombreComercial());
        response.setRepresentanteLegal(proveedor.getRepresentanteLegal());
        response.setCredito(proveedor.getCredito());
        response.setDireccion(proveedor.getDireccion());
        response.setTelefono(proveedor.getTelefono());
        response.setEstado(proveedor.getEstado());
        return response;
    }
}