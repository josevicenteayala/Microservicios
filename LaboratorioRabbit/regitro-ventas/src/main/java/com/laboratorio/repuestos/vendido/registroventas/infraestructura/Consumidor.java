package com.laboratorio.repuestos.vendido.registroventas.infraestructura;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.laboratorio.repuestos.vendido.registroventas.model.CentroCosto;


@Component
public class Consumidor implements MessageListener {
    @Override
    public void onMessage(Message message) {
    	/*lee la cola de cliente que tiene la confirmacion del pedido y procede a obtener el centro de costo
    	 * para luego dejar el mensaje en la cola de facturacion
    	*/
        String mensaje = new String( message.getBody());
		System.out.println("Procesando la confirmacion del pedido: "+mensaje);
        
        List<CentroCosto> listaCentrosCosto = obtenerCentrosCosto();
        Publicador publicador = new Publicador();
        publicador.publicarMensaje("exchange.pedido.confirmado", null, mensaje+" ------ "+listaCentrosCosto.get(0).toString());
    }

	public List<CentroCosto> obtenerCentrosCosto() {
		RestTemplate restTemplate = new RestTemplate();
        CentroCosto[] listaCentroCostosRetornada = restTemplate.getForObject("http://localhost:8080/obtenerCentroCostos", CentroCosto[].class);
        List<CentroCosto> listCentroCostos = Arrays.asList(listaCentroCostosRetornada);
        return listCentroCostos;
	}
}
