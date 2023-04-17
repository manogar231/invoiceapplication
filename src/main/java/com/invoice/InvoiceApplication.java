package com.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.invoice.util.PdfGenerator;

@SpringBootApplication
public class InvoiceApplication {

	@Bean
	public RestTemplate  restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public PdfGenerator pdfGenerator() {
		return new PdfGenerator();
	}
	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

}
