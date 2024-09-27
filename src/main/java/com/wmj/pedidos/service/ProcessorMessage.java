package com.wmj.pedidos.service;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class ProcessorMessage {

    private static final Logger log = Logger.getLogger(MessagePostProcessor.class.getName());

    private final PedidoService pedidoService;

    public void processMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            log.warning("Mensagem nula ou vazia");
            return;
        }

        try (JsonReader jsonReader = Json.createReader(new StringReader(message))) {
            JsonObject jsonObject = jsonReader.readObject();
            pedidoService.insert(jsonObject);
            log.info("Pedido processado com sucesso");
        } catch (JsonException e) {
            log.severe("Erro ao processar pedido: " + e.getMessage());
            throw new JsonException("Erro ao processar pedido: " + e.getMessage());
        }
    }
}
