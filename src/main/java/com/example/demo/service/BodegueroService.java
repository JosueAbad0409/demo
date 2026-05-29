package com.example.demo.service;

import com.example.demo.dto.request.BodegueroRequest;
import com.example.demo.model.Bodeguero;

import java.util.List;

public interface BodegueroService {

    Bodeguero createBodeguero(BodegueroRequest bodegueroRequest);
    Bodeguero getBodegueroById(Long id);
    Bodeguero updateBodeguero(BodegueroRequest bodegueroRequest);
    void deleteBodegueroById(Long id);
    List<Bodeguero> findAllBodeguero();
}
