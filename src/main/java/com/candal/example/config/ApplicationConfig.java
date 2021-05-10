package com.candal.example.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	//@Value("${fullFileName.example}")
	private String exampleFullFileName;

	//@Bean
	public String getReadFileToString() throws IOException {

		byte[] keyBytes = Files.readAllBytes(Paths.get(exampleFullFileName));
		return new String(keyBytes, StandardCharsets.UTF_8);
	}

}
