package com.poly.midware.config;//package com.poly.midware.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * Swagger2配置类
// *
// * @ProjectName: midware
// * @Package: com.poly.midware.config
// * @Author: longhai
// * @CreateDate: 2018/5/3
// * @Version: 1.0
// * <p>Copyright: Copyright (c) 2018</p>
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.poly.midware.api"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("保臻科技主数据平台APIS")
//                .description("Spring boot 使用Swagger2构建RESTful APIS")
//                .termsOfServiceUrl("http://www.shenzhenpoly.com")
//                .contact("龙海")
//                .version("1.0")
//                .build();
//    }
//}
