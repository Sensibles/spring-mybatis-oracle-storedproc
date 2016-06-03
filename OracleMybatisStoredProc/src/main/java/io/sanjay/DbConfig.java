package io.sanjay;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@MapperScan(value = {"io.sanjay.mapper"}, sqlSessionFactoryRef="sqlSessionFactory")
public class DbConfig {

	@Value("${db.user}")
	private String dbUser;

	@Value("${db.password}")
	private String dbPassword;

	@Value("${db.host}")
	private String dbHost;

	@Value("${db.database}")
	private String dbDatabase;

	@Value("${db.port}")
	private int dbPort;

	@Bean(name="dataSource")
	@Primary
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setServerName(dbHost);
		dataSource.setPortNumber(dbPort);
		dataSource.setDriverType("thin");
		 dataSource.setUser(dbUser);
		 dataSource.setPassword(dbPassword);
		 dataSource.setDatabaseName(dbDatabase);
		return dataSource;
	}

	@Bean(name="sqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory.getObject();
	}
}
