package com.wmj.pedidos.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class RabbitMQConfig {


    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${queue.pedidos}")
    private String queue;

    @Value("${exchange.pedidos}")
    private String exchange;

    @Value("${routingkey.pedidos}")
    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queue, false);
    }

    private ConnectionFactory connection() {
        var factory = new CachingConnectionFactory();
        factory.setHost(host);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setPort(5672);

        try {
            Connection connection = factory.createConnection();
            Channel channel = connection.createChannel(false);
            channel.queueDeclare(queue, false, false,false,null);
            channel.queueBind(queue,exchange, routingKey);
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException("Conexão com RabbitMQ recusada!!!");
        }
        return factory;
    }
}
