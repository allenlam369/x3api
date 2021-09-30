package allen.wqplis;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration(proxyBeanMethods = false)
@PropertySource({ "classpath:application.properties" })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "allen.wqplis.repository", entityManagerFactoryRef = "wqplisEntityManager", transactionManagerRef = "wqplisTransactionManager")
public class WqplisDatasourceConfig {
	@Autowired
	private Environment env;

	@Bean
	@ConfigurationProperties("spring.wqplisdatasource")
	public DataSourceProperties wqplisDataSourceProperties() {
		return new DataSourceProperties();
	}

//	@Bean
//	@ConfigurationProperties("spring.wqplisdatasource")
//	public HikariDataSource wqplisDataSource(DataSourceProperties wqplisDataSourceProperties) {
//		return wqplisDataSourceProperties.initializeDataSourceBuilder().create().type(HikariDataSource.class).build();
//	}
//
//	private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties jpaProperties) {
//		JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(jpaProperties);
//		return new EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties.getProperties(), null);
//	}

	@Bean
	public LocalContainerEntityManagerFactoryBean wqplisEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(wqplisDataSource());
		em.setPackagesToScan(new String[] { "allen.wqplis.model" });
		em.setPersistenceUnitName("wqplis");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	public DataSource wqplisDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("spring.wqplisdatasource.driverClassName"));
		dataSource.setUrl(env.getProperty("spring.wqplisdatasource.url"));
		dataSource.setUsername(env.getProperty("spring.wqplisdatasource.username"));
		dataSource.setPassword(env.getProperty("spring.wqplisdatasource.password"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager wqplisTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(wqplisEntityManager().getObject());
		return transactionManager;
	}

//	private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
//		// ... map JPA properties as needed
//		return new HibernateJpaVendorAdapter();
//	}
}
