package com.github.anastasop.elementary.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.anastasop.elementary.entities.Country;
import com.github.anastasop.elementary.services.CountriesService;

@Controller
public class CountriesController {
	private CountriesService countriesService;
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getAllCountries() {
		return getCountriesService().getAllCountries();
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.POST, consumes = "application/json")
	public void addCountry(@RequestBody Country country, HttpServletResponse response) {
		getCountriesService().addCountry(country);
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
	}
	
	
	public CountriesService getCountriesService() {
		return countriesService;
	}

	@Autowired(required = true)
	public void setCountriesService(CountriesService countriesService) {
		this.countriesService = countriesService;
	}
}
