package az.baau.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BaauApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaauApplication.class, args);
	}

}
