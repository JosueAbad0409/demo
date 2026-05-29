package com.example.demo.service;

import com.example.demo.dto.request.BodegueroRequest;
import com.example.demo.dto.response.BodegueroResponse;

import java.util.List;

public interface BodegueroService {
    BodegueroResponse createBodeguero(BodegueroRequest bodegueroRequest);
    BodegueroResponse getBodegueroById(Long id);
    BodegueroResponse updateBodeguero(Long id, BodegueroRequest bodegueroRequest);
    void deleteBodegueroById(Long id);
    List<BodegueroResponse> findAllBodeguero();
}