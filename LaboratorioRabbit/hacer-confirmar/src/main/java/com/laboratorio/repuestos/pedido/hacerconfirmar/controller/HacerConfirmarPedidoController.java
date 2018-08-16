package com.laboratorio.repuestos.pedido.hacerconfirmar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laboratorio.repuestos.pedido.hacerconfirmar.infraestructura.Publicador;
import com.laboratorio.repuestos.pedido.hacerconfirmar.model.Pedido;

@RestController
public class HacerConfirmarPedidoController {

	private Publicador publicador = new Publicador();
	
	@RequestMapping(method = RequestMethod.POST, value = "/hacer")
	public ResponseEntity<String> hacerPedido(@RequestBody(required=true) Pedido pedido){
        publicador.publicarMensaje("exchange.repuesto.pedido",pedido.getTipoSolicitud(),
                "Pedido solicitado " + pedido.getCodigoConfirmacion() + " valor: " + pedido.getValor());
        
        //se procede a procesa el pedido y a notificar al cliente
        
        publicador.publicarMensaje("exchange.repuesto.pedido","pedido-confirmacion",
                "Pedido solicitado " + pedido.getCodigoConfirmacion() + " valor: " + pedido.getValor());
        
		return new ResponseEntity<>("Pedido realizado",HttpStatus.OK);
	}	
}
