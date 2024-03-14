package com.rmk.learnspb;

import com.rmk.learnspb.service.NameSvc;
import com.rmk.learnspb.service.NameSvcImpl;
import com.rmk.learnspb.service.NameSvcImpl2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication

public class LearnSpbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpbApplication.class, args);
	}


	@Bean @Primary
	public NameSvc getNameSvcImpl2(){
		return new NameSvcImpl2();
	}


	@Bean("one")
	public NameSvc getNameSvcImpl(){
		return new NameSvcImpl();
	}
}
