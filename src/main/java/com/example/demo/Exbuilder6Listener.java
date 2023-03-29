package com.example.demo;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cleopatra.XBInitializer;


@Configuration
public class Exbuilder6Listener {


	@Bean
	public ServletListenerRegistrationBean getServletListenerRegistrationBean() {
		ServletListenerRegistrationBean listener = new ServletListenerRegistrationBean(new XBInitializer());
		
		return listener;
	}

}