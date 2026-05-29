package com.example.demo.service;

import com.example.demo.dto.request.BodegaRequest;
import com.example.demo.dto.response.BodegaResponse;

import java.util.List;

public interface BodegaService {
    BodegaResponse createBodega(BodegaRequest bodegaRequest);
    BodegaResponse getBodegaById(Long id);
    BodegaResponse updateBodega(Long id, BodegaRequest bodegaRequest);
    void deleteBodegaById(Long id);
    List<BodegaResponse> findAllBodegas();
}