package com.poly.midware;

import com.poly.midware.config.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class MidwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(MidwareApplication.class, args);
    }
}
