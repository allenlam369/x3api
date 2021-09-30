package allen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;

//@Bean
//@Primary
//@ConfigurationProperties(prefix="spring.datasource")
//public DataSource primaryDataSource() {
//    return DataSourceBuilder.create().build();
//}
//
//@Bean
//@ConfigurationProperties(prefix="spring.wqplisDatasource")
//public DataSource secondaryDataSource() {
//    return DataSourceBuilder.create().build();
//}


@SpringBootApplication
// one includes @Configuration, @EnableAutoConfiguration and @ComponentScan
@ConfigurationProperties(prefix="spring.datasource")
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
	}

}

// query by HKT, output in GMT
// http:// localhost:5050/uvi/between?st=20210909_1200&ed=20210911_1200

//query by HKT, output in GMT
//http://localhost:5050/uvi/on?date=20210909

// yesterday and today
//http://localhost:5050/uvi/twoDays

// in the last 7 days including today
//http://localhost:5050/uvi/oneWeek
