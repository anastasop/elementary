package com.github.anastasop.elementary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.anastasop.elementary.services.MessageService;

@Controller
public class SimpleController {
	private MessageService messageService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain")
	public void respond(@RequestParam("draft") String draft, Model model) {
		String message = messageService.makeMessage(draft);
		model.addAttribute("message", message);
		// expect to render a view named 'hello' with a two attributes: 'applicationName' and 'message'
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = "text/html")
	public void introduce() {
		// expect to render a view named 'index' with a single attribute: 'applicationName'
	}
	
	@ModelAttribute("applicationName")
	public String getApplicationName() {
		return "elementary/spring-hibernate";
	}

	public MessageService getMessageService() {
		return messageService;
	}

	@Autowired(required = true)
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
}
