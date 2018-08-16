package com.laboratorio.repuestos.vendido.registroventas.infraestructura;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.laboratorio.repuestos.vendido.registroventas.model.CentroCosto;


@Component
public class ConsumidorFacturacion implements MessageListener {
    @Override
    public void onMessage(Message message) {
        String mensaje = new String( message.getBody());
		System.out.println("Procesando el registro en facturacion: "+mensaje);
    }

}
