package com.rdvmedecin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author SKAN
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.rdvmedecin" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(
				"/static/");
	}

	// configuration dispatcherservlet pour lees headers CORS
	// @Bean
	// public DispatcherServlet dispatcherServlet() {
	// DispatcherServlet servlet = new DispatcherServlet();
	// servlet.setDispatchOptionsRequest(true);
	// return servlet;
	// }

	// @Override
	// public void configureViewResolvers(ViewResolverRegistry registry) {
	// InternalResourceViewResolver viewResolver = new
	// InternalResourceViewResolver();
	// viewResolver.setViewClass(JstlView.class);
	// viewResolver.setPrefix("/WEB-INF/views/");
	// viewResolver.setSuffix(".jsp");
	// registry.viewResolver(viewResolver);
	// }

}
