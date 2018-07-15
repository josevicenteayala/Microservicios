package io.swagger.configuration;

import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Cotejo;

public class Utiles {

	
	public List<Cotejo> listaCotejos(){
	    List<Cotejo> lst = new ArrayList<>();
	    Cotejo c1 = new Cotejo("1", "t123", "Colombia", "Inglaterra");
	    Cotejo c2 = new Cotejo("2", "t123", "Belgica", "Brasil");
	    Cotejo c3 = new Cotejo("3", "t123", "Suecia", "Inglaterra");
	    Cotejo c4 = new Cotejo("4", "t123", "Croacia", "Rusia");
	    lst.add(c1);
	    lst.add(c2);
	    lst.add(c3);
	    lst.add(c4);
	    return  lst;
	}
	
}
