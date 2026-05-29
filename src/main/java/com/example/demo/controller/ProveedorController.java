package com.example.demo.controller;

import com.example.demo.dto.request.ProveedorRequest;
import com.example.demo.dto.response.ProveedorResponse;
import com.example.demo.service.ProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorResponse>> getAllProveedores() {
        return ResponseEntity.ok(proveedorService.findAllProveedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(proveedorService.getProveedorById(id));
    }

    @PostMapping
    public ResponseEntity<ProveedorResponse> create(@Valid @RequestBody ProveedorRequest request) {
        ProveedorResponse response = proveedorService.createProveedor(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponse> update(@PathVariable Long id, @Valid @RequestBody ProveedorRequest request) {
        return ResponseEntity.ok(proveedorService.updateProveedor(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        proveedorService.deleteProveedorById(id);
        return ResponseEntity.ok("Proveedor eliminado correctamente");
    }
}