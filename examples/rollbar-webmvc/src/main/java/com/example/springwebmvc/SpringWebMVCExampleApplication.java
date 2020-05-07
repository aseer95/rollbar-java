package com.example.springwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import com.rollbar.notifier.Rollbar;
import com.rollbar.notifier.config.Config;
import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;
import org.springframework.web.servlet.HandlerExceptionResolver;
import com.rollbar.springboot.RollbarExceptionResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;

@SpringBootApplication
@Configuration()
@ComponentScan()
public class SpringWebMVCExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRollbarSpringBootApplication.class, args);
	}

	@Bean
	public HandlerExceptionResolver rollbarExceptionResolver() {
		return new RollbarExceptionResolver(Rollbar.init(withAccessToken("<POST_SERVER_ACCESS_TOKEN>").build()));
	}

}
