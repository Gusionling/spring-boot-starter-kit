package com.hyeongkyu.template.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName   : com.hyeongkyu.template.global.error
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 30.
 * Description   :
 */
@Getter
@RequiredArgsConstructor
public class CommonException extends RuntimeException {

    private final ErrorCode errorCode;

    @Override
    public String getMessage() {
        return errorCode.getMessage();
    }
}
