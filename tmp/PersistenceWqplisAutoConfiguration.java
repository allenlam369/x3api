package allen.wqplis;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration()
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = "allen.wqplis.model", entityManagerFactoryRef = "wqplisEntityManager", transactionManagerRef = "wqplisTransactionManager")
public class PersistenceWqplisAutoConfiguration {
	@Bean
	@ConfigurationProperties(prefix = "spring.wqplisdatasource")
	public DataSource wqplisDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean(name = "wqplisEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("wqplisDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("allen.wqplis.model").persistenceUnit("wqplis").build();
	}

	@Bean(name = "wqplisTransactionManager")
	public PlatformTransactionManager metTransactionManager(
			@Qualifier("wqplisEntityManagerFactory") EntityManagerFactory wqplisEntityManagerFactory) {
		return new JpaTransactionManager(wqplisEntityManagerFactory);
	}

}
