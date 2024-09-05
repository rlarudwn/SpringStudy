package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDAO2;
@ComponentScan(basePackages = {"com.sist.*"})
public class EmpConfig {
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		Resource res=new ClassPathResource("config.xml");
		ssf.setConfigLocation(res);
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	@Bean("mapper")
	public MapperFactoryBean mapperFactoryBean() {
		MapperFactoryBean mapper=new MapperFactoryBean();
		try {
			mapper.setSqlSessionFactory(sqlSessionFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapper;
	}
}
