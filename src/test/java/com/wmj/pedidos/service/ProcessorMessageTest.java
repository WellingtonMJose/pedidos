package com.wmj.pedidos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.json.JsonException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;

class ProcessorMessageTest {

    @InjectMocks
    private ProcessorMessage processorMessage;

    @Mock
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processMessage() {
        String message = "{\n" +
                "    \"codigoPedido\":17,\n" +
                "    \"codigoCliente\":3,\n" +
                "    \"itens\":[\n" +
                "        {\n" +
                "            \"produto\":\"Carro VW - tiguan\",\n" +
                "            \"quantidade\":1,\n" +
                "            \"preco\":90000.10\n" +
                "        },\n" +
                "        {\n" +
                "            \"produto\":\"Som\",\n" +
                "            \"quantidade\":1,\n" +
                "            \"preco\":1599.99\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        processorMessage.processMessage(message);
        Mockito.verify(pedidoService, Mockito.times(1)).insert(Mockito.any());
    }

    @Test
    void processMessageExceptionNull() {
        String message = "{json iiiii}";
        JsonException exception = assertThrows(JsonException.class, () -> {
            processorMessage.processMessage(message);
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    void testProcessorMessageExceptionEmpty(){
        processorMessage.processMessage("");
        Mockito.verify(pedidoService, never()).insert(Mockito.any());
    }
    @Test
    void testProcessMessage_NullMessage() {
        processorMessage.processMessage(null);

        Mockito.verify(pedidoService, never()).insert(Mockito.any());
    }

    @Test
    void testProcessMessage_EmptyMessage() {
        processorMessage.processMessage("");

        Mockito.verify(pedidoService, never()).insert(Mockito.any());
    }
}