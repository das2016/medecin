package com.rdvmedecin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages={"com.rdvmedecin"})
@Import({DaoConfig.class})
public class ServiceConfig {}
