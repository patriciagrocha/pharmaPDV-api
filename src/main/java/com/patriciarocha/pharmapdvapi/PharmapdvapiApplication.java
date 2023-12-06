package com.patriciarocha.pharmapdvapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PharmapdvapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmapdvapiApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		var mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		return mapper;
	}
}
