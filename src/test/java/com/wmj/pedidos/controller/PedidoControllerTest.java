package com.wmj.pedidos.controller;

import com.wmj.pedidos.model.entity.Cliente;
import com.wmj.pedidos.model.entity.ItemPedidoEntity;
import com.wmj.pedidos.model.entity.ItemPedidoPK;
import com.wmj.pedidos.model.entity.PedidoEntity;
import com.wmj.pedidos.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = PedidoController.class)
class PedidoControllerTest {

    @InjectMocks
    private PedidoController pedidoController;

    @MockBean
    private PedidoService pedidoService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void find() throws Exception {
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
        Mockito.when(pedidoService.find(Mockito.anyLong())).thenReturn(pedido);

        this.mockMvc.perform(
                get("/api/v1/pedidos/1")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAllPedidosCliente() throws Exception {
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
        Mockito.when(pedidoService.findAllByCliente(Mockito.anyLong())).thenReturn(List.of(pedido));

        this.mockMvc.perform(
                get("/api/v1/pedidos/cliente/1")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getValorTotal() throws Exception {
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
        Mockito.when(pedidoService.find(1L)).thenReturn(pedido);

        this.mockMvc.perform(
                get("/api/v1/pedidos/total/1")
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getQuantidadePedidos() throws Exception {
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
        Mockito.when(pedidoService.findAllByCliente(Mockito.anyLong())).thenReturn((List.of(pedido)));

        this.mockMvc.perform(
                get("/api/v1/pedidos/cliente/quantidade/1")
                        .contentType(MediaType.APPLICATION_JSON));
    }
}