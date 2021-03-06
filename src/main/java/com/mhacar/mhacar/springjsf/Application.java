package com.mhacar.mhacar.springjsf;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.ConfigureListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@Configuration
@EntityScan("com.mhacar.entity")
@EnableJpaRepositories("com.mhacar.repository")
@ComponentScan("com.mhacar")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//JSF Configration
	@Bean
	public ServletRegistrationBean<FacesServlet> facesServletRegistraiton() {
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<FacesServlet>(new FacesServlet(),
				new String[] { "*.xhtml" });
		registration.setName("Faces Servlet");
		registration.setLoadOnStartup(1);

		return registration;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
			//Primefacesin ücretsiz temalarından bootstrap örneği yaptık değiştirebilirsiniz
			servletContext.setInitParameter("primefaces.THEME", "bootstrap");
			//Primefaces client browser tarafında kontrol edilebilme örneğin textbox 10 karakter olmalı vs..
			servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
			//Xhtml sayfalarında commentlerin parse edilmemesi.
			servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
			//primefaces icon set için
			servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
		};
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}
	//JSF Confi	gration
}
