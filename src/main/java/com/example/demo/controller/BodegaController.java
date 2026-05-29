package com.example.demo.controller;

import com.example.demo.dto.request.BodegaRequest;
import com.example.demo.dto.response.BodegaResponse;
import com.example.demo.service.BodegaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bodegas")
@RequiredArgsConstructor
public class BodegaController {

    private final BodegaService bodegaService;

    @GetMapping
    public ResponseEntity<List<BodegaResponse>> getAllBodegas() {
        return ResponseEntity.ok(bodegaService.findAllBodegas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegaResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bodegaService.getBodegaById(id));
    }

    @PostMapping
    public ResponseEntity<BodegaResponse> create(@Valid @RequestBody BodegaRequest request) {
        BodegaResponse response = bodegaService.createBodega(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegaResponse> update(@PathVariable Long id, @Valid @RequestBody BodegaRequest request) {
        return ResponseEntity.ok(bodegaService.updateBodega(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        bodegaService.deleteBodegaById(id);
        return ResponseEntity.ok("Bodega eliminada correctamente");
    }
}