package com.gxuwu.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LhqSpringbootAdminApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(LhqSpringbootAdminApplication.class, args);

        String[] beanDefinitionNames = run.getBeanDefinitionNames();

        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
    }

}
