package com.mhacar.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

@Controller(value = "helloBean")
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 4085285875380136779L;
	private String message = "JSF demo ";

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	
}
