package com.gmail.deamon999;

import com.gmail.deamon999.entities.Singer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Singer singer = context.getBean(Singer.class);
        System.out.println(singer);
    }
}
