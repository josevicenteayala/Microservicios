package com.laboratorio.repuestos.vendido.registroventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegitroVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegitroVentasApplication.class, args);
	}
}
