package com.example.demo.controller;


import com.example.demo.dto.request.BodegueroRequest;
import com.example.demo.dto.response.BodegueroResponse;
import com.example.demo.service.BodegueroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bodegueros")
@RequiredArgsConstructor
public class BodegueroController {

    private final BodegueroService bodegueroService;

    @GetMapping
    public ResponseEntity<List<BodegueroResponse>> getAllBodegueroes() {
        return ResponseEntity.ok(bodegueroService.findAllBodeguero());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegueroResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bodegueroService.getBodegueroById(id));
    }

    @PostMapping
    public ResponseEntity<BodegueroResponse> create(@Valid @RequestBody BodegueroRequest request) {
        BodegueroResponse response = bodegueroService.createBodeguero(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegueroResponse> update(@PathVariable Long id, @Valid @RequestBody BodegueroRequest request) {
        return ResponseEntity.ok(bodegueroService.updateBodeguero(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        bodegueroService.deleteBodegueroById(id);
        return ResponseEntity.ok("Bodeguero eliminado correctamente");
    }
}
