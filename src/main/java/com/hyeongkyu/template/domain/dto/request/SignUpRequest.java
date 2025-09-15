package com.hyeongkyu.template.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName   : com.hyeongkyu.template.domain.dto.request
 * Author        : imhyeong-gyu
 * Data          : 2025. 9. 15.
 * Description   :
 */
public record SignUpRequest(
        @NotNull
        @Schema(description = "providerId", example = "203912941")
        Long providerId,

        @NotBlank
        @Schema(description = "이메일", example = "example@email.com")
        String email,

        @NotBlank
        @Schema(description = "닉네임", example = "럭키비키")
        String nickName,  // 네이밍 컨벤션: camelCase

        @NotBlank
        @Schema(description = "비밀번호", example = "1234")
        String password


        ) {


}

