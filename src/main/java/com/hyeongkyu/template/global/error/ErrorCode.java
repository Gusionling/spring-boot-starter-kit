package com.hyeongkyu.template.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * packageName   : com.hyeongkyu.template.global.error
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 25.
 * Description   :
 */

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 400 BAD REQUEST
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "E400001", "유효하지 않은 입력값입니다."),
    INVALID_PARAMETER_FORMAT(HttpStatus.BAD_REQUEST, "E400002", "잘못된 형식의 파라미터입니다."),
    MISSING_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "E400003", "필수 파라미터가 누락되었습니다."),
    BAD_REQUEST_JSON(HttpStatus.BAD_REQUEST, "E400004", "잘못된 JSON 형식입니다."),

    // 401 UNAUTHORIZED
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E401001", "인증이 필요합니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "E401002", "유효하지 않은 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "E401003", "만료된 토큰입니다."),

    // 403 FORBIDDEN
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "E403001", "접근 권한이 없습니다."),

    // 404 NOT FOUND
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "E404001", "요청한 리소스를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "E404002", "사용자를 찾을 수 없습니다."),
    NOT_FOUND_END_POINT(HttpStatus.NOT_FOUND, "E404003","존재하지 않는 API 엔드포인트입니다."),


    // 409 CONFLICT
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "E409001", "이미 존재하는 리소스입니다."),

    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E500001", "서버 내부 오류가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
