package br.com.alura.microservice.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class LojaApplication {
	
	//LoadBalanced dá a inteligência para a instância de RestTemplate conseguir resolver o nome "fornecedor" no Eureka, ou seja, troca esse nome pelo IP e porta
	//e também faz sempre uma requisição para uma instância disponível diferente
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate( ) {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

}
