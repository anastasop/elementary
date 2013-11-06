package com.github.anastasop.elementary.services;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	private String prefix;
	
	public MessageService(String prefix) {
		this.prefix = prefix;
	}
	
	public String makeMessage(String draft) {
		return prefix + ":" + draft.toUpperCase();
	}
}
