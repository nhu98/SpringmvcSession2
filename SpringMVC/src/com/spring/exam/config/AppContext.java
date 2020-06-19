package com.spring.exam.config;




import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource ("/WEB-INF/configs/database.properties")
@EnableTransactionManagement

public class AppContext {
	@Autowired
	private Environment enviroment;
	@Autowired
	private ResourcePatternResolver resourloader;
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getRequiredProperty("jdbc.DriverClassname"));
		dataSource.setUrl(enviroment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(enviroment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(enviroment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setConfigLocation(resourloader.getResource("/WEB-INF/configs/mybatis-config.xml"));
		sessionFactory.setMapperLocations(resourloader.getResources("/WEB-INF/mappers/*.xml"));
		return sessionFactory.getObject();
	}
	@Bean
	public SqlSessionTemplate sqlSessionTemplate()throws Exception{
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sessionFactory());
		return sessionTemplate;
	}
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	
	
	

}
