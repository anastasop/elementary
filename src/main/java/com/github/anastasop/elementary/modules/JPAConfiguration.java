package com.github.anastasop.elementary.modules;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfiguration {
	@Bean(name = "dataSource")
	public DataSource providesDataSource() {
		org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setUsername("sa");
		ds.setPassword("");
		ds.setUrl("jdbc:hsqldb:file:/tmp/elementary.db");
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		return ds;
	}
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean providesEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(providesDataSource());
		return emf;
	}
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager providesTransactionManager() {
		return new JpaTransactionManager();
	}
}
