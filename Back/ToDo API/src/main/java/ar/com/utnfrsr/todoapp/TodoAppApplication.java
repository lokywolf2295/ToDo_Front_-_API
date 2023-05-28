package ar.com.utnfrsr.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(TodoAppApplication.class, args);
        System.out.println("Hola desde SprigBoot");
    }

}
