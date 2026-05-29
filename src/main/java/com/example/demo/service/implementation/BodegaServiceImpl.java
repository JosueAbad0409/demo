package com.example.demo.service.implementation;

import com.example.demo.dto.request.BodegaRequest;
import com.example.demo.dto.response.BodegaResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bodega;
import com.example.demo.model.Bodeguero;
import com.example.demo.repository.RepositoryBodega;
import com.example.demo.repository.RepositoryBodeguero;
import com.example.demo.service.BodegaService;
import com.example.demo.service.mapper.BodegaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaServiceImpl implements BodegaService {

    private final RepositoryBodega repositoryBodega;
    private final RepositoryBodeguero repositoryBodeguero;
    private final BodegaMapper bodegaMapper;

    @Override
    @Transactional
    public BodegaResponse createBodega(BodegaRequest bodegaRequest) {
        Bodeguero bodeguero = repositoryBodeguero.findById(bodegaRequest.getIdBodeguero())
                .orElseThrow(() -> new ResourceNotFoundException("El bodeguero asignado no existe"));

        Bodega bodega = repositoryBodega.save(bodegaMapper.toEntity(bodegaRequest, bodeguero));
        return bodegaMapper.toResponseDto(bodega);
    }

    @Override
    @Transactional(readOnly = true)
    public BodegaResponse getBodegaById(Long id) {
        Bodega bodega = repositoryBodega.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La bodega no existe"));
        return bodegaMapper.toResponseDto(bodega);
    }

    @Override
    @Transactional
    public BodegaResponse updateBodega(Long id, BodegaRequest bodegaRequest) {
        Bodega bodega = repositoryBodega.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La bodega no existe"));

        Bodeguero bodeguero = repositoryBodeguero.findById(bodegaRequest.getIdBodeguero())
                .orElseThrow(() -> new ResourceNotFoundException("El bodeguero asignado no existe"));

        bodega.setNombre(bodegaRequest.getNombre());
        bodega.setUbicacion(bodegaRequest.getUbicacion());
        bodega.setEstado(bodegaRequest.getEstado());
        bodega.setBodeguero(bodeguero);

        Bodega bodegaGuardada = repositoryBodega.save(bodega);
        return bodegaMapper.toResponseDto(bodegaGuardada);
    }

    @Override
    @Transactional
    public void deleteBodegaById(Long id) {
        if (!repositoryBodega.existsById(id)) {
            throw new ResourceNotFoundException("La bodega con ID " + id + " no existe.");
        }
        repositoryBodega.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BodegaResponse> findAllBodegas() {
        return repositoryBodega.findAll().stream()
                .map(bodegaMapper::toResponseDto)
                .toList();
    }
}