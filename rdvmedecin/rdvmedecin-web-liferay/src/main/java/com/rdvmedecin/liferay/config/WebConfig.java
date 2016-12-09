package com.rdvmedecin.liferay.config;

import java.util.HashMap;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.rdvmedecin.config.ServiceConfig;
import com.rdvmedecin.liferay.scope.ViewScope;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.rdvmedecin" })
@Import(value = { ServiceConfig.class })
public class WebConfig {

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("serial")
	@Bean
	public static CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer csc = new CustomScopeConfigurer();
		csc.setScopes(new HashMap<String, Object>() {
			{
				put("view", new ViewScope());
			}
		});
		return csc;
	}
}
