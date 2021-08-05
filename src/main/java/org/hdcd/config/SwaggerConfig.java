package org.hdcd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
	@EnableSwagger2
	public class SwaggerConfig {

		//apiInfo 메인으로 보여질 정보 설정
	    private ApiInfo apiInfo() {

	        return new ApiInfoBuilder()
	                .title("Demo")
	                .description("API EXAMPLE")
	                .build();
	    }

	    @Bean
	    public Docket commonApi() { // api의 그룹명이나 이동경로 ,보여질 api가 속한 패키지등으 자세한 정보
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("example")
	                .apiInfo(this.apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors
	                        .basePackage("org.hdcd.controller"))
	                .paths(PathSelectors.ant("/api/**"))
	                .build();
	    }

	}


