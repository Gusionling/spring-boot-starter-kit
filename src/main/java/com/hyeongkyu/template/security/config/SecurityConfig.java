package com.hyeongkyu.template.security.config;

import com.hyeongkyu.template.global.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * packageName   : com.hyeongkyu.template.security.config
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 21.
 * Description   :
 */

@Configuration // 스프링한테 '여기 설정정보 있어요, 참고하세요'라고 알려주는 거
@EnableWebSecurity // "우리 프로젝트에서 Spring Security 사용할거에요"라고 알려주는 거
public class SecurityConfig {

    @Bean //"이 메소드가 반환하는 객체를 스프링이 관리해야해요"
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(registry ->
                        registry
                                .requestMatchers(Constants.NO_NEED_AUTH_URLS.toArray(String[]::new)).permitAll()
                                .anyRequest().authenticated()
                )

                .build();
    }
}
