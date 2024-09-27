package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableCaching(order = 3)
class SpringBootAopExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopExampleApplication.class, args);
		//System.out.println("welcome");
	}

}
