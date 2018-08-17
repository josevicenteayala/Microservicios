package com.laboratorio.repuestos.validadorpedido.controller;

import com.laboratorio.repuestos.validadorpedido.infraestructura.Publicador;
import com.laboratorio.repuestos.validadorpedido.model.Repuesto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Random;

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

    public @ResponseBody
    ResponseEntity<Repuesto> confirmarRepuesto(@RequestBody Repuesto repuesto){
        String respuesta =ValidarRepuesto();
        publicador.publicarMensaje("exchange.repuesto.validado",repuesto.getTipoSolicitud(), respuesta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String ValidarRepuesto(){
        Random rand = new Random();
        String respuesta = null;
        int  n = rand.nextInt(2) ;
        if(n<1){
            respuesta =   "Repuesto no disponible";
        }
        else{
            Integer codigo = rand.nextInt();
            respuesta ="Codigo confirmacion: " + codigo.toString();
        }

        return respuesta;
    }

}
