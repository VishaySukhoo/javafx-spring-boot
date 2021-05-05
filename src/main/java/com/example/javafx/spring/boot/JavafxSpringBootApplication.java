package com.example.javafx.spring.boot;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafxSpringBootApplication {

    public static void main(String[] args) {
//		Instead of using SpringApplication to run the application, we’ll use the JavaFX Application class
//		SpringApplication.run(JavafxSpringBootApplication.class, args);
        Application.launch(SearchApplication.class, args);

    }

}
