package com.cnksi.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/***
* @Description: knife4j 配置
* @Author: Mr.Tang
* @Date: 2022/10/9
*/
@Configuration
@EnableKnife4j//该注解是knife4j提供的增强注解,Ui提供了例如动态参数、参数过滤、接口排序等增强功能,
//@EnableSwaggerBootstrapUI
//如果你想使用这些增强功能就必须加该注解，否则可以不用加
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    /***
    * @Description: 
    * @Param: []
    * @return: springfox.documentation.spring.web.plugins.Docket
    * @Author: Mr.Tang
    * @Date: 2023/10/31
    */
    @Bean
    public Docket createRestApiForCzp() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.kjczwl"))
                .paths(PathSelectors.any()).build().groupName("时代数码").pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("时代数码 API接口文档")
                .description("使用 knife4j 搭建的 时代数码 API接口文档")
                .termsOfServiceUrl("http://localhost:8080/")
                .version("1.0.0")
                .build();
    }
}
