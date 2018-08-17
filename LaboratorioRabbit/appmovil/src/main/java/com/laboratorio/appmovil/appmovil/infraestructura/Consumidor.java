package com.laboratorio.appmovil.appmovil.infraestructura;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Consumidor  implements MessageListener {
    @Override
    public void onMessage(Message message) {
        String mensaje = new String(message.getBody());
        System.out.println(mensaje);
    }
}
