package comida.apigateway.comidaapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ComidaapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComidaapigatewayApplication.class, args);
	}
}
