package com.gmail.deamon999;

import com.gmail.deamon999.entities.Singer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JavaConfiguration {

    @Bean
    public Singer singer() {
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Doe");
        return singer;
    }
}
