package allen.met;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration()
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = "allen.met.repository", entityManagerFactoryRef = "metEntityManagerFactory", transactionManagerRef = "metTransactionManager")
public class PersistenceMetAutoConfiguration {
	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource")
	public HikariDataSource metDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean(name = "metEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("metDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("allen.met.model").persistenceUnit("met").build();
	}

	@Primary
	@Bean(name = "metTransactionManager")
	public PlatformTransactionManager metTransactionManager(
			@Qualifier("metEntityManagerFactory") EntityManagerFactory metEntityManagerFactory) {
		return new JpaTransactionManager(metEntityManagerFactory);
	}	
}
