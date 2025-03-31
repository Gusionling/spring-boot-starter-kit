package com.hyeongkyu.template.global.error;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * packageName   : com.hyeongkyu.template.global.error
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 23.
 * Description   :
 */

@Getter
public class ExceptionDto {
        @Schema(name = "code", description = "에러 코드")
        @NotNull
        private final String code;

        @Schema(name = "message", description = "에러 메시지")
        @NotNull private final String message;

        public ExceptionDto(ErrorCode errorCode) {
                this.code = errorCode.getCode();
                this.message = errorCode.getMessage();
        }

        public static ExceptionDto of(ErrorCode errorCode) {
                return new ExceptionDto(errorCode);
        }
}
