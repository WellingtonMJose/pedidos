package com.wmj.pedidos.controller;

import com.wmj.pedidos.model.dto.ClienteDTO;
import com.wmj.pedidos.model.entity.Cliente;
import com.wmj.pedidos.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "Inserir cliente")
    public ResponseEntity<?> insert( @RequestBody ClienteDTO dto) {
        Cliente cliente = clienteService.insert(dto);
        return ResponseEntity.ok().body(cliente.getId());
    }
}
