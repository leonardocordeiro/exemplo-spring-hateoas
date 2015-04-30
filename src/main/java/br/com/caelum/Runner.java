package br.com.caelum;


import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("br.com.caelum")
@EnableAutoConfiguration
public class Runner {
	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
	
	@Bean
	public DataSource getDataSource() throws PropertyVetoException { 
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost/springboot");
		ds.setUser("root");
		
		return ds;
	}
	
}
