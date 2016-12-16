package vn.hamalaja.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author lamhm
 *
 */
@SpringBootApplication
public class Application {
	private static ApplicationContext applicationContext;


	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}


	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Application.class, args);
	}
}
