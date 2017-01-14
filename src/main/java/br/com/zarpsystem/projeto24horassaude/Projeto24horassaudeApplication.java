package br.com.zarpsystem.projeto24horassaude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.zarpsystem.projeto24horassaude")
public class Projeto24horassaudeApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Projeto24horassaudeApplication.class, args);
	}
}
