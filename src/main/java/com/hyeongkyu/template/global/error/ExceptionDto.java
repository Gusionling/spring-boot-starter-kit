package com.hyeongkyu.template.global.error;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * packageName   : com.hyeongkyu.template.global.error
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 23.
 * Description   :
 */

@Schema(name = "ExceptionDto", description = "예외 응답 객체")
public record ExceptionDto(
        @Schema(name = "에러 코드", description = "에러 코드")
        String code,
        @Schema(name = "에러 메시지", description = "에러 메시지")
        String message){

        public static ExceptionDto of(ErrorCode errorCode) {
                return new ExceptionDto(errorCode.getCode(), errorCode.getMessage());
        }
}
