package com.rdvmedecin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author SKAN
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.rdvmedecin" })
public class WebConfig {

}
