package com.wmj.pedidos.service;

import com.wmj.pedidos.model.entity.ItemPedidoEntity;
import com.wmj.pedidos.model.entity.ItemPedidoPK;
import com.wmj.pedidos.model.entity.PedidoEntity;
import com.wmj.pedidos.model.exception.ObjectNotFoundException;
import com.wmj.pedidos.model.repository.ItemPedidoRepository;
import com.wmj.pedidos.model.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private PedidoRepository repository;

    private ItemPedidoRepository itemPedidoRepositorio;

    private ClienteService clienteService;

    public PedidoService(PedidoRepository repository, ItemPedidoRepository itemPedidoRepositorio, ClienteService clienteService) {
        this.repository = repository;
        this.itemPedidoRepositorio = itemPedidoRepositorio;
        this.clienteService = clienteService;
    }

    public PedidoEntity find(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Pedido não encontrado! Id: " + id ));
    }

    @Transactional
    public PedidoEntity insert(JsonObject obj) {
        PedidoEntity pedido = new PedidoEntity();
        pedido.setId(obj.asJsonObject().getJsonNumber("codigoPedido").longValue());
        pedido.setCliente(clienteService.find(obj.asJsonObject().getJsonNumber("codigoCliente").longValue()));
        pedido = repository.save(pedido);
        List<ItemPedidoEntity> itensPedido = new ArrayList<>();
        for (JsonValue ip : obj.getJsonArray("itens")) {
            ItemPedidoPK itemId = new ItemPedidoPK();
            itemId.setPedido(pedido);
            itemId.setProduto(ip.asJsonObject().getJsonString("produto").getString());
            ItemPedidoEntity ipItem = new ItemPedidoEntity();
            ipItem.setIdPk(itemId);
            ipItem.setPreco(ip.asJsonObject().getJsonNumber("preco").doubleValue());
            ipItem.setQuantidade(ip.asJsonObject().getJsonNumber("quantidade").intValue());
            itensPedido.add(ipItem);
        }
        itemPedidoRepositorio.saveAll(itensPedido);
        return pedido;
    }

    public List<PedidoEntity> findAllByCliente(Long id) {
        clienteService.find(id);
        return repository.findByClienteId(id).orElseThrow(() -> new ObjectNotFoundException(
                "Pedido não encontrado! Id: " + id));
    }

}
