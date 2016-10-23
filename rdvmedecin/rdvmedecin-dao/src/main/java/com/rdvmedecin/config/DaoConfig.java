package com.rdvmedecin.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * 
 * @author SKAN
 * 
 */
@Configuration
@Import({ DataBaseConfig.class })
@EnableJpaRepositories({ "com.rdvmedecin.springdatajpa" })
public class DaoConfig {
	@Autowired
	DataSource dataSource;
	@Autowired
	Environment environment;
	public static final String PACKAGE_SCAN = "com.rdvmedecin.entity";

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaProperties(getHibernateJpaProperties());
		entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
		entityManagerFactoryBean.setDataSource(this.dataSource);
		entityManagerFactoryBean
				.setPackagesToScan(new String[] { "com.rdvmedecin.entity" });
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean.getObject();
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		JpaDialect jpaDialect = new HibernateJpaDialect();
		transactionManager.setJpaDialect(jpaDialect);
		return transactionManager;
	}

	/**
	 * Hibernate properties
	 * @return
	 */
	public Properties getHibernateJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect",this.environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql",this.environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto",this.environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.generate_statistics",this.environment.getProperty("hibernate.generate_statistics"));
		return properties;
	}
}
