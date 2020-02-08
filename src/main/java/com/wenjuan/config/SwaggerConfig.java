package com.wenjuan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wxt.dyh
 * @version V1.0
 * @date 2020/2/7/0007 22:10:15
 */
/**
 * @Configuration 声明该类为配置类
 * @EnableSwagger2 声明启动Swagger2
 * @EnableWebMvc 声明启动mvc 配置此注解通过包扫描，不需要进行spring bean xml 配置
 * */
@Configuration  //让Spring来加载该类配置
@EnableWebMvc   //非SpringBoot需启用
@EnableSwagger2 //启用Swagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wenjuan.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线问卷 API")
                .description("在线问卷接口文档")
                .termsOfServiceUrl("http://localhost:8888/")
                .contact("1943295589@qq.com")
                .version("1.0")
                .build();
    }
}
