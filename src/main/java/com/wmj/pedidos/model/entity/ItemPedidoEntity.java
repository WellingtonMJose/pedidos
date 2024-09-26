package com.wmj.pedidos.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class ItemPedidoEntity implements Serializable {

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK idPk = new ItemPedidoPK();


    private Integer quantidade;
    private double preco;
    public ItemPedidoEntity() {
    }

    public ItemPedidoEntity(PedidoEntity pedido, String produto, Integer quantidade, Double preco) {
        super();
        idPk.setPedido(pedido);
        idPk.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public double getSubtotal() {
        return (preco * quantidade);
    }


}
