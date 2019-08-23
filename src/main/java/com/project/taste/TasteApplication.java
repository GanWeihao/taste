package com.project.taste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class TasteApplication {
    private static final Logger logger = LoggerFactory.getLogger(TasteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TasteApplication.class, args);
        logger.debug("--Application Started--");
    }

}
