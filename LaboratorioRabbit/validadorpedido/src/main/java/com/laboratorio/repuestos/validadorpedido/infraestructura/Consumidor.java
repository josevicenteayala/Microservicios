package com.laboratorio.repuestos.validadorpedido.infraestructura;

import com.laboratorio.repuestos.validadorpedido.controller.ValidadorController;
import com.laboratorio.repuestos.validadorpedido.model.Repuesto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;


@Component
public class Consumidor implements MessageListener {
    @Override
    public void onMessage(Message message) {
        String mensaje = new String(message.getBody());
        System.out.println(mensaje);
        ValidadorController validarRepuesto = new ValidadorController();
        Repuesto repuesto = new Repuesto();
        repuesto.setTipoSolicitud("solicitud-confirmada");
        validarRepuesto.confirmarRepuesto(repuesto);
    }
}
