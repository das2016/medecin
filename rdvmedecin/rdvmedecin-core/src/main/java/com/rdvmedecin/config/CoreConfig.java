package com.rdvmedecin.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
/**
 * 
 * @author SKAN
 *
 */
@Configuration
@PropertySource({"classpath:application.properties"})
public class CoreConfig
{
	private static final String APPLICATION_PROPERTIES = "application.properties";

	/**
	 * Proprty placeholder used for retrieving the value's propertie
	 * 
	 * @return
	 */
  @Bean
  public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
  {
    PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
    ppc.setLocation(new ClassPathResource(APPLICATION_PROPERTIES));
    ppc.setIgnoreUnresolvablePlaceholders(true);
    return ppc;
  }
}
