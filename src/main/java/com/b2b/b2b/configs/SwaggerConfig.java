package com.b2b.b2b.configs;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private static final String SWAGGER_API_VERSION = "1.0.0";
	private static final String LICENSE_TEXT = "License";
	private static final String TITLE = "B2B Rest Api";
	private static final String DESCRIPTION = "Documentation for b2b Api";

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(TITLE).license(LICENSE_TEXT).description(DESCRIPTION)
				.version(SWAGGER_API_VERSION).build();
	}

	@Bean
	public Docket B2BApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build()
				.securitySchemes(Arrays.asList(apiKey())).securityContexts(Arrays.asList(securityContext()));
	}

	private ApiKey apiKey() {
		return new ApiKey("swaggerKey", "Authorization", "Authorization");
		// return new BasicAuth("");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/*.*"))
				.build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("swaggerKey", authorizationScopes));
	}

	@Bean
	springfox.documentation.swagger.web.SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder().clientId("test-app-client-id")
				.clientSecret("test-app-client-secret").realm("test-app-realm").appName("test-app").scopeSeparator(",")
				.additionalQueryStringParams(null).useBasicAuthenticationWithAccessCodeGrant(false).build();
	}

}
