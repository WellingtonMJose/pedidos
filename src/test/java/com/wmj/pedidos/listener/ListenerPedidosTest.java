package com.wmj.pedidos.listener;

import com.wmj.pedidos.service.ProcessorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ListenerPedidosTest {

    @InjectMocks
    private ListenerPedidos listenerPedidos;

    @Mock
    private ProcessorMessage processorMessage;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void recebePedidos() throws Exception {
        byte[] messageMock = new byte[] { 72, 101, 108, 108, 111 };
        listenerPedidos.recebePedidos(messageMock);
        Mockito.verify(processorMessage, Mockito.times(1)).processMessage(Mockito.any());
    }
}