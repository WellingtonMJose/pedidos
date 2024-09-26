package com.wmj.pedidos.controller;

import com.wmj.pedidos.model.dto.ClienteDTO;
import com.wmj.pedidos.model.entity.Cliente;
import com.wmj.pedidos.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/v1/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "Inserir cliente")
    public ResponseEntity<Void> insert( @RequestBody ClienteDTO dto) {
        Cliente obj = clienteService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
