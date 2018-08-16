package com.laboratorio.repuestos.validadorpedido.controller;

import com.laboratorio.repuestos.validadorpedido.infraestructura.Publicador;
import com.laboratorio.repuestos.validadorpedido.model.Repuesto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidadorController {
    Publicador publicador = new Publicador();

    @RequestMapping(method = RequestMethod.POST, value="/validarRepuesto")
    public @ResponseBody
    ResponseEntity<Repuesto> validarRepuesto(@RequestBody Repuesto repuesto){

        publicador.publicarMensaje("exchange.repuesto.validado",repuesto.getTipoSolicitud(),
                "Repuesto por validar " + repuesto.getIdRepuesto() + " ciudad: " + repuesto.getCiudad());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    ResponseEntity<Repuesto> confirmarRepuesto(@RequestBody Repuesto repuesto){

        publicador.publicarMensaje("exchange.repuesto.confirmado",repuesto.getTipoSolicitud(),
                "Repuesto por validar " + repuesto.getIdRepuesto() + " ciudad: " + repuesto.getCiudad());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
