package com.rdvmedecin.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import({ CoreConfig.class })
public class DataBaseConfig {
	
	@Autowired
	Environment environment;

	/**
	 * Datasource Bean Config
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setPassword(this.environment.getProperty("jdbc.password"));
		dataSource.setUsername(this.environment.getProperty("jdbc.username"));
		dataSource.setUrl(this.environment.getProperty("jdbc.url"));
		dataSource.setDriverClassName(this.environment
				.getProperty("jdbc.driverClassName"));
		return dataSource;
	}
}
