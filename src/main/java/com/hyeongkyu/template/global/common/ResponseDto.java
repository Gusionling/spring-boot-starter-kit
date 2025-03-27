package com.hyeongkyu.template.global.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyeongkyu.template.global.error.ExceptionDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * packageName   : com.hyeongkyu.template.global.common
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 23.
 * Description   :
 */

@Slf4j
@Schema(name="ResponseDto", description = "공통 응답 객체")
public record ResponseDto<T>(@JsonIgnore HttpStatus httpStatus,
                             @Schema(name = "success", description = "API 호출 성공 여부")
                             @NotNull Boolean success,
                             @Schema(name = "data", description = "API 호출 성공 시 응답 데이터")
                             @Nullable T data,
                             @Schema(name = "error", description = "API 호출 실패 시 응답 에러")
                             @Nullable String message) {

    public static <T> ResponseDto<?> ok(@Nullable final T data){
        return new ResponseDto<>(HttpStatus.OK, true, data, null);
    }

    public static ResponseDto<Object> fail(final Exception e){
        return new ResponseDto<>(HttpStatus.BAD_REQUEST, false, null, e.getMessage());
    }


}
