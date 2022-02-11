package com.rodrigo;

import com.rodrigo.model.Course;
import com.rodrigo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CourseRepository repository) {
        return args -> {
            repository.deleteAll();

            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory("front-end");

            repository.save(c);
        };
    }
}
