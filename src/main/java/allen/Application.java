package allen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// one includes @Configuration, @EnableAutoConfiguration and0 @ComponentScan
public class Application {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
