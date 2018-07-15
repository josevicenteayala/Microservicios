package comida.mexicana.comidamexicana.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import comida.mexicana.comidamexicana.dominio.Burrito;

@RestController
public class BurritoController {

	@RequestMapping(value="/burrito",method = RequestMethod.GET)
	public ResponseEntity<Burrito> consultarBurrito(){
		
		Burrito burrito = new Burrito();
		burrito.setIdBurrito(1);
		burrito.setTipoBurrito("Ranchero");
		return new ResponseEntity<>(burrito ,null,HttpStatus.OK);
	}
	
}
