package com.rdvmedecin.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 * @author SKAN
 * 
 */
public class WebConfigInitializer implements WebApplicationInitializer {

	
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(new Class[] { WebConfigContext.class });
		ctx.setServletContext(container);
		ServletRegistration.Dynamic servlet = container.addServlet("rdvmedecin", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping(new String[] { "/" });
	}
}
