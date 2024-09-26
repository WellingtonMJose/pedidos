package com.wmj.pedidos.listener;

import com.wmj.pedidos.service.ProcessorMessage;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListenerPedidos {

    private final ProcessorMessage processorMessage;

    @RabbitListener(queues = "${queue.pedidos}")
    public void recebePedidos(byte[] payload) throws Exception {
        String pedido = new String(payload);
        processorMessage.processMessage(pedido);
    }
}
