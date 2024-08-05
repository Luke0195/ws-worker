package com.workercompras;

import com.workercompras.model.Endereco;
import com.workercompras.service.CepService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableRabbit
@EnableFeignClients
@SpringBootApplication
public class WorkercompraasApplication {

	@Autowired
	private CepService cepService;

	public static void main(String[] args) {
		SpringApplication.run(WorkercompraasApplication.class, args);
	}

	@Bean
	public 	Endereco teste(){
		cepService.buscarCep("3121044012041240");
		return new Endereco();
	}
}
