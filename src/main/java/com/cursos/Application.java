package com.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers"}) //Para que acceda al resto de paquetes y no de error por no estar en el ppal
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
