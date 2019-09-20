package com.genesis.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.genesis")
public class ProjectConfig {

	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setSuffix(".jsp");
		vr.setPrefix("/WEB-INF/pages/");
		return vr;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan("com.genesis");

		Properties props=new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		
		sessionFactory.setHibernateProperties(props);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@"+sessionFactory);
		return sessionFactory;
	}
	
	
	@Bean
	public ComboPooledDataSource myDataSource(){
		ComboPooledDataSource ob=new ComboPooledDataSource();
		try {
			ob.setDriverClass("oracle.jdbc.driver.OracleDriver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ob.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ob.setUser("javatraining");
		ob.setPassword("hawking");
		
		return ob;
	}
	
	
}


