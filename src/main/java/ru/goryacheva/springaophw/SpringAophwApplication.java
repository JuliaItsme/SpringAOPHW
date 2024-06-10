package ru.goryacheva.springaophw;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringAophwApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAophwApplication.class, args);
    }
}