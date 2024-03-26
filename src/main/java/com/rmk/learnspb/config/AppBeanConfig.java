package com.rmk.learnspb.config;

import com.rmk.learnspb.service.NameSvc;
import com.rmk.learnspb.service.NameSvcImpl;
import com.rmk.learnspb.service.NameSvcImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppBeanConfig {
    @Bean
    @Primary
    public NameSvc getNameSvcImpl2(){
        return new NameSvcImpl2();
    }


    @Bean("one")
    public NameSvc getNameSvcImpl(){
        return new NameSvcImpl();
    }
}
