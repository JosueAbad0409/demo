package com.example.demo.service.implementation;

import com.example.demo.dto.request.BodegueroRequest;
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
    public Bodeguero createBodeguero(BodegueroRequest bodegueroRequest) {
        Bodeguero bodeguero = repositoryBodeguero.save(bodegueroMapper.toEntity(bodegueroRequest));
        return bodegueroMapper.toResponseDto(bodeguero);
    }

    @Override
    public Bodeguero getBodegueroById(Long id) {
        return null;
    }

    @Override
    public Bodeguero updateBodeguero(BodegueroRequest bodegueroRequest) {
        return null;
    }

    @Override
    public void deleteBodegueroById(Long id) {

    }

    @Override
    public List<Bodeguero> findAllBodeguero() {
        return List.of();
    }
}
