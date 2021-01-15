package com.setsailfeng.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDiscoveryClient//启用注册中心。与@EnableEurekaClient注解的功能相同，但是这个注解不局限在Eureka
//@EnableEurekaClient 只能用于Eureka D版本开头的Eureka是不可以省略这个注解的。
@SpringBootApplication
public class ProviderMainTypeAtPort2022 {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderMainTypeAtPort2022.class, args);
	}

}
