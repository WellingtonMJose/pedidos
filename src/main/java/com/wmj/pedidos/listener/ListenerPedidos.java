package com.wmj.pedidos.listener;

import com.wmj.pedidos.service.ProcessorMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ListenerPedidos {

    private final ProcessorMessage processorMessage;

    @RabbitListener(queues = "${queue.pedidos}")
    public void recebePedidos(byte[] payload) throws Exception {
        log.info("Pedido recebido: {}", new String(payload));
        String pedido = new String(payload);
        processorMessage.processMessage(pedido);
    }
}
