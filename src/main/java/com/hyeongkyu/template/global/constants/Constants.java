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

    public static final List<String> NO_NEED_AUTH_URLS = List.of(
            "/v3/api-docs.html/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/api/v1/auth/**",
            "/api/v1/health/**"
    );

}
