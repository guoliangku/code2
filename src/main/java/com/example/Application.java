package com.example;

import com.example.config.DataSourceConfig;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceConfig.class})
@ComponentScan(basePackages = {"com.example.mapper","com.example.entity","com.example.service","com.example.controller","com.example.config"})
public class Application {

	private static Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		log.info("服务已启动");
		SpringApplication.run(Application.class, args);
	}


}
