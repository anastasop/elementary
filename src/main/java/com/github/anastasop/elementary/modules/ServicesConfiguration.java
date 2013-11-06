package com.github.anastasop.elementary.modules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.anastasop.elementary.services.CountriesService;
import com.github.anastasop.elementary.services.MessageService;

@Configuration
public class ServicesConfiguration {
	@Bean(name = "messageService") // default is method name
	@Scope("singleton")
	public MessageService provideMessageService() {
		return new MessageService("MessageService");
	}

	@Bean(name = "countriesService") // default is method name
	@Scope("singleton")
	public CountriesService provideCountriesService() {
		return new CountriesService();
	}
}
