package com.laboratorio.repuestos.vendido.registroventas.infraestructura;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitConection {
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("lion.rmq.cloudamqp.com");
        cachingConnectionFactory.setUsername("cqlouhuq");
        cachingConnectionFactory.setPassword("FDcuxWi7W4p2sTFszIAapA7imaPRXzz7");
        cachingConnectionFactory.setChannelCheckoutTimeout(10000);
        cachingConnectionFactory.setRequestedHeartBeat(300);
        cachingConnectionFactory.setVirtualHost("cqlouhuq");
        return cachingConnectionFactory;

    }
}
