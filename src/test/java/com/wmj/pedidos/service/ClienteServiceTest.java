package com.wmj.pedidos.service;

import com.wmj.pedidos.model.dto.ClienteDTO;
import com.wmj.pedidos.model.entity.Cliente;
import com.wmj.pedidos.model.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void find() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente");
        Mockito.when(clienteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(cliente));
        clienteService.find(1L);

        Mockito.verify(clienteRepository, Mockito.times(1)).findById(Mockito.anyLong());
    }

    @Test
    void insert() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente");
        ClienteDTO clienteDTO = new ClienteDTO("Cliente");
        Mockito.when(clienteRepository.save(Mockito.any())).thenReturn(cliente);
        clienteService.insert(clienteDTO);

        Mockito.verify(clienteRepository, Mockito.times(1)).save(Mockito.any());
    }
}