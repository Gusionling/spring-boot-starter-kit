package com.hyeongkyu.template.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * packageName   : com.hyeongkyu.template.domain.dto.request
 * Author        : imhyeong-gyu
 * Data          : 2025. 9. 15.
 * Description   :
 */
@Data
@RequiredArgsConstructor
public class LoginDto {

    @NotBlank
    @Schema(description = "이메일", example = "example@google.com")
    private final String email;

    @NotBlank
    @Schema(description = "비밀번호", example = "1234")
    private final String password;
}
