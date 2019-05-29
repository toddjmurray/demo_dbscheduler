package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	@Bean
	@FlywayDataSource
	@ConfigurationProperties(prefix="app.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
