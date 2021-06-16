package tw.util;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "tw")
public class RootAppConfig {
	
	// jndi
	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		jndiBean.setJndiName("java:comp/env/jdbc/myProject2");
		jndiBean.afterPropertiesSet();
		DataSource dataSource = (DataSource)jndiBean.getObject();
		return dataSource;
	}
	
	// session Factory
	@Bean(destroyMethod = "destroy")
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setPackagesToScan("tw");
		factory.setDataSource(dataSource());
		factory.setHibernateProperties(addProperties());
		return factory;
	}
	
	// Hibernate properties
	public Properties addProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServerDialect.class);
//		properties.put("hibernate.show_sql", Boolean.TRUE);
//		properties.put("hibernate.format_sql", Boolean.TRUE);
		return properties;
	}
	
	// tracnsaction 
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		System.out.println("-----初始化-----");
		System.out.println(sessionFactory);
		return txManager;
	}
}
