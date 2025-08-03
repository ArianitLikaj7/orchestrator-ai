package dev.arianit.orchestrartor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "dev.arianit.orchestrartor.client")
public class OrchestrartorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestrartorApplication.class, args);
	}

}
