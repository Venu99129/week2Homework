package com.week2.Week2HomeWork.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class globalConfigurations {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
