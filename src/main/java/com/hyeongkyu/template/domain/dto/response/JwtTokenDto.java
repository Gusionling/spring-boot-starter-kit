package com.hyeongkyu.template.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;

/**
 * packageName   : com.hyeongkyu.template.domain.dto.response
 * Author        : imhyeong-gyu
 * Data          : 2025. 9. 15.
 * Description   :
 */
@Builder
@Schema(name = "jwtTokenDto", description = "JWT 토큰 응답")
public record JwtTokenDto(

        @JsonProperty("accessToken")
        @NotNull(message = "accessToken 값은 필수 입니다")
        String accessToken,

        @JsonProperty("refresh token")
        String refreshToken

) implements Serializable {
    public static JwtTokenDto of(String accessToken, String refreshToken) {
        return JwtTokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
