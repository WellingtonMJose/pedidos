package com.wmj.pedidos.controller;

import com.wmj.pedidos.model.entity.Cliente;
import com.wmj.pedidos.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = ClienteController.class)
class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void insert() throws Exception {
        String request = "{\"nome\": \"Cliente Teste\"}";
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente");
        Mockito.when(clienteService.insert(Mockito.any())).thenReturn(cliente);
        this.mockMvc.perform(
                post("/api/v1/clientes")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON));
    }
}