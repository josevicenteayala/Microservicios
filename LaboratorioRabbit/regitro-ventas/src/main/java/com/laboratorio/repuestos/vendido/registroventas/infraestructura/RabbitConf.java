package com.laboratorio.repuestos.vendido.registroventas.infraestructura;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {
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
    
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return  rabbitTemplate;
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("cola.cliente");
        container.setMessageListener(new Consumidor());
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return container;
    }
}
