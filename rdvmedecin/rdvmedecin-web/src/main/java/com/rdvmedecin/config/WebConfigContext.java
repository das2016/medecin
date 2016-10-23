package com.rdvmedecin.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author SKAN
 * 
 */
public class WebConfigContext extends	AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
