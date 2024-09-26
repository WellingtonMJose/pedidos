package com.wmj.pedidos.controller;

import com.wmj.pedidos.model.dto.PedidoDTO;
import com.wmj.pedidos.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pedidos")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Buscar pedido pelo código")
    public ResponseEntity<?> find(@PathVariable Long id) {
        PedidoDTO obj = pedidoService.find(id).toDTO();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/cliente/{id}")
    @Operation(summary = "Listar todos pedidos pelo código do cliente")
    public ResponseEntity<?> getAllPedidosCliente(@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.findAllByCliente(id));
    }

    @GetMapping(value = "/total/{id}")
    @Operation(summary = "Buscar valor total do pedido via id")
    public ResponseEntity<?> getValorTotal(@PathVariable Long id) {
        return ResponseEntity.ok().body("Pedido nº: "+ id+ " Valor Total: "+pedidoService.find(id).getValorTotalFormatado());
    }

    @GetMapping(value = "/cliente/quantidade/{id}")
    @Operation(summary = "Buscar quantidade de pedidos feito pelo codigo do cliente")
    public ResponseEntity<?> getQuantidadePedidos(@PathVariable Long id) {
        return ResponseEntity.ok().body("Total de "+pedidoService.findAllByCliente(id).size() +" pedidos pelo cliente "+id);
    }


}
