To add Swagger2 do the following

1. Add the following dependencies

	implementation('io.springfox:springfox-swagger2:2.9.2')
	implementation('io.springfox:springfox-swagger-ui:2.9.2')
	
2. Add a new package called config

3. Add a new class called Swagger2ConfigForCategory.java with the following code

package com.rollingstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2ConfigForCategory {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.build();
	}
}

3. Build

4. Run

5. Test with http://localhost:8092/swagger-ui.html

	A. GET All
	B. Create a new Category
	C. Test GET ALL again