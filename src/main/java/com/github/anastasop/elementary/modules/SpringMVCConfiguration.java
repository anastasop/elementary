package com.github.anastasop.elementary.modules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.github.anastasop.elementary.controllers.CountriesController;
import com.github.anastasop.elementary.controllers.SimpleController;

@Configuration
@EnableWebMvc
public class SpringMVCConfiguration extends WebMvcConfigurerAdapter {
	// extending WebMvcConfigurerAdapter is for additional configuration
	// just override one of its methods if needed
	
	@Bean
	public FreeMarkerConfigurer providesFreeMarkerConfigurer() {
		FreeMarkerConfigurer fmc = new FreeMarkerConfigurer();
		fmc.setTemplateLoaderPath("/WEB-INF/views/freemarker/");
		return fmc;
	}
	
	@Bean(name = "viewResolver")
	public FreeMarkerViewResolver providesViewResolver() {
		FreeMarkerViewResolver vr = new FreeMarkerViewResolver();
		vr.setCache(true);
		vr.setPrefix("");
		vr.setSuffix(".ftl");
		return vr;
	}
	
	@Bean(name = "mainController")
	public SimpleController providesMainController() {
		return new SimpleController();
	}
	
	@Bean(name = "countriesController")
	public CountriesController providesCountriesController() {
		return new CountriesController();
	}
}
