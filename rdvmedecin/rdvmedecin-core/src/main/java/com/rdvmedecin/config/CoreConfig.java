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
  @Bean
  public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
  {
    PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
    ppc.setLocation(new ClassPathResource("application.properties"));
    ppc.setIgnoreUnresolvablePlaceholders(true);
    return ppc;
  }
}
