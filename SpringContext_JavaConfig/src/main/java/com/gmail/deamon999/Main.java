package com.gmail.deamon999;

import com.gmail.deamon999.entities.Singer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        Singer singer = context.getBean(Singer.class);
        Singer singer1 = (Singer) context.getBean("singer");

        System.out.println("Singer been injected by type is equal by name: " + singer.equals(singer1));
    }
}
