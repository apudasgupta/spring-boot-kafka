package com.iatl.lt.consumer.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Apu Das Gupta
 *
 */

@Configuration
public class DBConfig {

	@Profile("dev")
	@Bean
	public DataSource devDataSource() {
		System.out.println("==> setting dev datasource");
		PoolProperties p = new PoolProperties();
		p.setUrl("jdbc:mysql://localhost:3306/my_location_tracker");
		p.setDriverClassName("com.mysql.cj.jdbc.Driver");
		p.setUsername("root");
		p.setPassword("");
		p.setJmxEnabled(true);
		p.setTestWhileIdle(false);
		p.setTestOnBorrow(true);
		p.setValidationQuery("SELECT 1");
		p.setTestOnReturn(false);
		p.setValidationInterval(30000);
		p.setTimeBetweenEvictionRunsMillis(30000);
		p.setMaxActive(100);
		p.setInitialSize(10);
		p.setMaxWait(10000);
		p.setRemoveAbandonedTimeout(60);
		p.setMinEvictableIdleTimeMillis(30000);
		p.setMinIdle(10);
		p.setLogAbandoned(true);
		p.setRemoveAbandoned(true);
		p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
				+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
		DataSource datasource = new DataSource();
		datasource.setPoolProperties(p);
		return datasource;

	}

	@Profile("testMetro")
	@Bean
	public DataSource testDataSource() {
		System.out.println("==> setting test datasource");
		PoolProperties p = new PoolProperties();
		p.setUrl("jdbc:mysql://localhost:3306/iatl_location_tracker");
		p.setDriverClassName("com.mysql.cj.jdbc.Driver");
		p.setUsername("root");
		p.setPassword("IatlBD@123");
		p.setJmxEnabled(true);
		p.setTestWhileIdle(false);
		p.setTestOnBorrow(true);
		p.setValidationQuery("SELECT 1");
		p.setTestOnReturn(false);
		p.setValidationInterval(30000);
		p.setTimeBetweenEvictionRunsMillis(30000);
		p.setMaxActive(100);
		p.setInitialSize(10);
		p.setMaxWait(10000);
		p.setRemoveAbandonedTimeout(60);
		p.setMinEvictableIdleTimeMillis(30000);
		p.setMinIdle(10);
		p.setLogAbandoned(true);
		p.setRemoveAbandoned(true);
		p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
				+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
		DataSource datasource = new DataSource();
		datasource.setPoolProperties(p);
		return datasource;

	}

	
}
