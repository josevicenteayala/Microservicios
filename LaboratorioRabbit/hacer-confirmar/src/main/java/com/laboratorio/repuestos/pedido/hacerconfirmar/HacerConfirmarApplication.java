package com.laboratorio.repuestos.pedido.hacerconfirmar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HacerConfirmarApplication {

	public static void main(String[] args) {
		SpringApplication.run(HacerConfirmarApplication.class, args);
	}
}
