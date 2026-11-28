package pe.edu.isil.libro_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
public class LibroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibroServiceApplication.class, args);
	}

}
