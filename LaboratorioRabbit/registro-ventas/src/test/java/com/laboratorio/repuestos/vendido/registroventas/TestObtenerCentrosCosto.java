package com.laboratorio.repuestos.vendido.registroventas;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.laboratorio.repuestos.vendido.registroventas.infraestructura.Consumidor;
import com.laboratorio.repuestos.vendido.registroventas.model.CentroCosto;

public class TestObtenerCentrosCosto {

	@Test
	public void test() {
		Consumidor consumidor = new Consumidor();
		List<CentroCosto> listaCentroCosto = consumidor.obtenerCentrosCosto();
		assertNotNull(listaCentroCosto);
		Iterator<CentroCosto> iterator = listaCentroCosto.iterator();
		while(iterator.hasNext()) {
			CentroCosto centroCosto = iterator.next();
			System.out.println("ID Centro Costo: "+centroCosto.getId()+", nombre: "+centroCosto.getNombre());
		}
	}

}
