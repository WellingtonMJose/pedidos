package com.wmj.pedidos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PedidoDTO {
    private long codigoPedido;
    private long codigoCliente;
    private ItemDTO[] itens;

    public PedidoDTO() {

    }
}
