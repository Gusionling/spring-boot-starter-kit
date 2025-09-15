package com.hyeongkyu.template.global.constants;

import java.util.List;

/**
 * packageName   : com.hyeongkyu.template.global.constants
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 21.
 * Description   :
 */
public class Constants {

    public static final String API_PREFIX = "/api/v1";

    //인증 관련
    public static String USER_ID_CLAIM_NAME = "uid";
    public static String BEARER_PREFIX = "Bearer ";
    public static String AUTHORIZATION_HEADER = "Authorization";
    public static String USER_ROLE = "ROLE_USER";

    public static final List<String> NO_NEED_AUTH_URLS = List.of(
            "/v3/api-docs.html/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/api/v1/auth/**",
            "/api/v1/health/**"
    );

}
