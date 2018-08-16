package com.laboratorio.centrocostos.centrocostos.controller;

import com.laboratorio.centrocostos.centrocostos.model.CentroCosto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CentroCostosController {

    @RequestMapping(method = RequestMethod.GET, value = "/obtenerCentroCostos")
    public ResponseEntity <List <CentroCosto>> obtenerCentroCostos(){
        List<CentroCosto> centroCostos = new ArrayList<>();

        CentroCosto centroCosto = new CentroCosto();
        centroCosto.setId(1);
        centroCosto.setNombre("Contabilidad");
        centroCostos.add(centroCosto);

        CentroCosto centroCosto2 = new CentroCosto();
        centroCosto2.setId(2);
        centroCosto2.setNombre("Tecnologia");
        centroCostos.add(centroCosto2);

        CentroCosto centroCosto3 = new CentroCosto();
        centroCosto3.setId(3);
        centroCosto3.setNombre("Recursos humanos");
        centroCostos.add(centroCosto3);

        return new ResponseEntity<List<CentroCosto>>(centroCostos,HttpStatus.OK);
    }
}
