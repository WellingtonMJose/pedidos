package com.wmj.pedidos.service;

import com.wmj.pedidos.model.entity.Cliente;
import com.wmj.pedidos.model.entity.ItemPedidoEntity;
import com.wmj.pedidos.model.entity.ItemPedidoPK;
import com.wmj.pedidos.model.entity.PedidoEntity;
import com.wmj.pedidos.model.repository.ItemPedidoRepository;
import com.wmj.pedidos.model.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ClienteService clienteService;

    @Mock
    private ItemPedidoRepository itemPedidoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void find() {
        ItemPedidoEntity itemPedido = new ItemPedidoEntity();
        itemPedido.setQuantidade(10);
        itemPedido.setPreco(5.0);
        ItemPedidoPK itemPedidoPK = new ItemPedidoPK();
        itemPedidoPK.setProduto("carro");
        itemPedido.setIdPk(itemPedidoPK);
        PedidoEntity pedido = new PedidoEntity();
        itemPedidoPK.setPedido(pedido);
        pedido.setId(1L);
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente");
        pedido.setCliente(cliente);
        Mockito.when(pedidoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pedido));
        pedidoService.find(1L);

        Mockito.verify(pedidoRepository, Mockito.times(1)).findById(Mockito.anyLong());

    }

    @Test
    void insert() {
        ItemPedidoEntity itemPedido = new ItemPedidoEntity();
        itemPedido.setQuantidade(10);
        itemPedido.setPreco(5.0);
        ItemPedidoPK itemPedidoPK = new ItemPedidoPK();
        itemPedidoPK.setProduto("carro");
        itemPedido.setIdPk(itemPedidoPK);
        PedidoEntity pedido = new PedidoEntity();
        itemPedidoPK.setPedido(pedido);
        pedido.setId(1L);
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente");
        pedido.setCliente(cliente);
        Mockito.when(clienteService.find(Mockito.anyLong())).thenReturn(cliente);
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("codigoPedido", 1)
                .add("codigoCliente", 1)
                .add("itens", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("produto", "carro")
                                .add("quantidade", 10)
                                .add("preco", 5.0))
                        .build())
                .build();
        pedidoService.insert(jsonObject);

        Mockito.verify(pedidoRepository, Mockito.times(1)).save(Mockito.any());
        Mockito.verify(itemPedidoRepository, Mockito.times(1)).saveAll(Mockito.any());
    }

    @Test
    void findAllByCliente() {
        ItemPedidoEntity itemPedido = new ItemPedidoEntity();
        itemPedido.setQuantidade(10);
        itemPedido.setPreco(5.0);
        ItemPedidoPK itemPedidoPK = new ItemPedidoPK();
        itemPedidoPK.setProduto("carro");
        itemPedido.setIdPk(itemPedidoPK);
        PedidoEntity pedido = new PedidoEntity();
        itemPedidoPK.setPedido(pedido);
        pedido.setId(1L);
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente");
        pedido.setCliente(cliente);

        Mockito.when(clienteService.find(Mockito.anyLong())).thenReturn(cliente);
        Mockito.when(pedidoRepository.findByClienteId(Mockito.anyLong())).thenReturn(Optional.of(List.of(pedido)));
        pedidoService.findAllByCliente(1L);

        Mockito.verify(pedidoRepository, Mockito.times(1)).findByClienteId(Mockito.anyLong());
    }
}