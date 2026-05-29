package com.example.demo.service.implementation;

import com.example.demo.dto.request.BodegueroRequest;
import com.example.demo.dto.response.BodegueroResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bodeguero;
import com.example.demo.repository.RepositoryBodeguero;
import com.example.demo.service.BodegueroService;
import com.example.demo.service.mapper.BodegueroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegueroServiceImpl implements BodegueroService {


    private final RepositoryBodeguero repositoryBodeguero;
    private final BodegueroMapper bodegueroMapper;


    @Override
    @Transactional
    public BodegueroResponse createBodeguero(BodegueroRequest bodegueroRequest) {
        Bodeguero bodeguero = repositoryBodeguero.save(bodegueroMapper.toEntity(bodegueroRequest));
        return bodegueroMapper.toResponseDto(bodeguero);
    }

    @Override
    @Transactional(readOnly = true)
    public BodegueroResponse getBodegueroById(Long id) {
        Bodeguero bodeguero = repositoryBodeguero.getReferenceById(id);
        return bodegueroMapper.toResponseDto(bodeguero);
    }

    @Override
    @Transactional
    public BodegueroResponse updateBodeguero(Long id, BodegueroRequest bodegueroRequest) {
        Bodeguero bodeguero = repositoryBodeguero.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("El bodeguero no existe"));
        bodeguero.setNombre(bodegueroRequest.getNombre());
        bodeguero.setApellido(bodegueroRequest.getApellido());
        bodeguero.setEstado(bodegueroRequest.getEstado());

        Bodeguero bodegeroguardado = repositoryBodeguero.save(bodeguero);
        return  bodegueroMapper.toResponseDto(bodegeroguardado);
    }

    @Override
    @Transactional
    public void deleteBodegueroById(Long id) {
        if (!repositoryBodeguero.existsById(id)) {
            throw new ResourceNotFoundException("El bodeguero con ID " + id + " no existe.");
        }
        repositoryBodeguero.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BodegueroResponse> findAllBodeguero() {
        return repositoryBodeguero.findAll().stream()
                .map(bodegueroMapper::toResponseDto)
                .toList();
    }
}
