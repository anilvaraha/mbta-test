package com.statestreet.exam.mbtatest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:url.properties")
public class ApplicationConfiguration {

	

	@Bean(name = "routesTemplate")
	public RestTemplate getRoutesTemplate() {

		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		RestTemplate template = new RestTemplate(factory);
		return template;

	}

}
