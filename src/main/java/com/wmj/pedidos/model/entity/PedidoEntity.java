package com.wmj.pedidos.model.entity;

import com.wmj.pedidos.model.dto.ItemDTO;
import com.wmj.pedidos.model.dto.PedidoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_pedidos")
public class PedidoEntity {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "idPk.pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemPedidoEntity> itens = new HashSet<>();

    public double getValorTotal() {
        double soma = 0.0;
        for (ItemPedidoEntity iten : itens) {
            soma = soma + iten.getSubtotal();
        }
        return soma;
    }
    public String getValorTotalFormatado() {
        double total = getValorTotal();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return currencyFormat.format(total);
    }
    public PedidoDTO toDTO() {
        PedidoDTO dto = new PedidoDTO();
        dto.setCodigoPedido(this.id);
        dto.setCodigoCliente(this.cliente.getId());

        ItemDTO[] itemDTOS = this.itens.stream()
                .map(item -> {
                    ItemDTO itemDTO = new ItemDTO(item.getIdPk().getProduto(),item.getQuantidade(),item.getPreco());
                    return itemDTO;
                })
                .toArray(ItemDTO[]::new);

        dto.setItens(itemDTOS);
        return dto;
    }
}
