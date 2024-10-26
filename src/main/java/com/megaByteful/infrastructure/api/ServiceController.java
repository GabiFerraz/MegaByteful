package com.megaByteful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megaByteful.domain.Service;
import com.megaByteful.usecase.RegisterServiceUseCase;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    private final RegisterServiceUseCase registerServiceUseCase;

    @PostMapping
    public ResponseEntity<Service> registerService(@RequestBody Service service) {
        return ResponseEntity.ok(registerServiceUseCase.execute(service));
    }

    // Outros endpoints (atualizar, buscar etc.)
}