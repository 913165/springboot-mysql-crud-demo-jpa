package org.example.pbooksapp001;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class PbooksApp001Application {

    public static void main(String[] args) {
        SpringApplication.run(PbooksApp001Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(AbstractEnvironment environment) {
        return args -> {
            System.out.println("Application Properties:");
            environment.getPropertySources().stream()
                    .filter(ps -> ps instanceof EnumerablePropertySource)
                    .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                    .flatMap(Arrays::stream)
                    .distinct()
                    .forEach(prop -> System.out.println(prop + ": " + environment.getProperty(prop)));
        };
    }

}
