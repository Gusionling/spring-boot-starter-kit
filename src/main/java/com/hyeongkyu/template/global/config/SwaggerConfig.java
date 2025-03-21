package com.hyeongkyu.template.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

/**
 * packageName   : com.hyeongkyu.template.global.config
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 21.
 * Description   :
 */

@Configuration
@OpenAPIDefinition // API 문저를 정의하는 클래스임을 나타낸다.
public class SwaggerConfig {

    // JWT 보안 스키마 정리
    // SecurityScheme 이 API 인증 방식을 정의한다.
    private final SecurityScheme securityScheme = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer") // Bearer 토큰 방식을 사용할건데 JWT는 보통 Bearer 토큰 방식을 사용한다.
            .bearerFormat("JWT") // 토큰 형식은 JWT ㅇㅇ
            .in(SecurityScheme.In.HEADER) // 인증정보가 HTTP 헤더에 담겨있다.
            .name("Authorization"); // 헤더의 이름은 Authorization 이다.

    {
        SpringDocUtils.getConfig().replaceWithSchema(Color.class,
                new Schema<String>()
                        .type("string")
                        .format("color")
                        .example("#FFFFFFFF"));

        SpringDocUtils.getConfig().replaceWithSchema(LocalDateTime.class,
                new Schema<LocalDateTime>()
                        .type("string")
                        .format("date-time")
                        .example(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));

        SpringDocUtils.getConfig().replaceWithSchema(LocalDate.class,
                new Schema<LocalDate>()
                        .type("string")
                        .format("date")
                        .example(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)));

        SpringDocUtils.getConfig().replaceWithSchema(LocalTime.class,
                new Schema<LocalTime>()
                        .type("string")
                        .format("time")
                        .example(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
    }

    @Bean
    public OpenAPI openApi() {
        String description = "Spring Boot 템플릿";
        String securityRequirementName = "bearerAuth";
        return new OpenAPI()
                .servers(Collections.singletonList(new Server().url("/")))
                .security(Collections.singletonList(new SecurityRequirement().addList(securityRequirementName)))
                .components(new Components().addSecuritySchemes(securityRequirementName, securityScheme))
                .info(new Info()
                        .title(" API")
                        .description(description)
                        .version("0.0.1")
                )
                .externalDocs(new ExternalDocumentation().description("Spring Boot 프로젝트 템플릿 API 문서"));
    }


}
