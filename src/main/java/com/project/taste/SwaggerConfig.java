package com.project.taste;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 Config
 *
 * @author gwh
 * 正常这里使用@Configuration初始化配置,如果项目引入junit测试需要使用@WebAppConfiguration
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.project.taste.controller")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.taste.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("GanWeihao", "", "18290605616@163.com");
        return new ApiInfoBuilder()
                .title("Swagger 1.x API接口文档")
                .description("")
                .contact(contact)
                .version("1.0.0")
                .build();
    }

}