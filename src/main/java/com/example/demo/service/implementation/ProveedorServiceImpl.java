package com.example.demo.service.implementation;

import com.example.demo.dto.request.ProveedorRequest;
import com.example.demo.dto.response.ProveedorResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Proveedor;
import com.example.demo.repository.RepositoryProveedor;
import com.example.demo.service.ProveedorService;
import com.example.demo.service.mapper.ProveedorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final RepositoryProveedor repositoryProveedor;
    private final ProveedorMapper proveedorMapper;

    @Override
    @Transactional
    public ProveedorResponse createProveedor(ProveedorRequest proveedorRequest) {
        Proveedor proveedor = repositoryProveedor.save(proveedorMapper.toEntity(proveedorRequest));
        return proveedorMapper.toResponseDto(proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public ProveedorResponse getProveedorById(Long id) {
        Proveedor proveedor = repositoryProveedor.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El proveedor no existe"));
        return proveedorMapper.toResponseDto(proveedor);
    }

    @Override
    @Transactional
    public ProveedorResponse updateProveedor(Long id, ProveedorRequest proveedorRequest) {
        Proveedor proveedor = repositoryProveedor.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El proveedor no existe"));

        proveedor.setRuc(proveedorRequest.getRuc());
        proveedor.setNombreComercial(proveedorRequest.getNombreComercial());
        proveedor.setRepresentanteLegal(proveedorRequest.getRepresentanteLegal());
        proveedor.setCredito(proveedorRequest.getCredito());
        proveedor.setDireccion(proveedorRequest.getDireccion());
        proveedor.setTelefono(proveedorRequest.getTelefono());
        proveedor.setEstado(proveedorRequest.getEstado());

        Proveedor proveedorGuardado = repositoryProveedor.save(proveedor);
        return proveedorMapper.toResponseDto(proveedorGuardado);
    }

    @Override
    @Transactional
    public void deleteProveedorById(Long id) {
        if (!repositoryProveedor.existsById(id)) {
            throw new ResourceNotFoundException("El proveedor con ID " + id + " no existe.");
        }
        repositoryProveedor.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorResponse> findAllProveedores() {
        return repositoryProveedor.findAll().stream()
                .map(proveedorMapper::toResponseDto)
                .toList();
    }
}