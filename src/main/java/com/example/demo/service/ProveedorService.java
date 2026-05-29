package com.example.demo.service;

import com.example.demo.dto.request.ProveedorRequest;
import com.example.demo.dto.response.ProveedorResponse;

import java.util.List;

public interface ProveedorService {
    ProveedorResponse createProveedor(ProveedorRequest proveedorRequest);
    ProveedorResponse getProveedorById(Long id);
    ProveedorResponse updateProveedor(Long id, ProveedorRequest proveedorRequest);
    void deleteProveedorById(Long id);
    List<ProveedorResponse> findAllProveedores();
}