package io.agileintelligence.ppmtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import io.agileintelligence.ppmtool.web.ProjectController;

@SpringBootApplication
@Import(io.agileintelligence.ppmtool.exceptions.CustomResponseEntityResponseHandler.class)
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class PpmtoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpmtoolApplication.class, args);
	}

}
