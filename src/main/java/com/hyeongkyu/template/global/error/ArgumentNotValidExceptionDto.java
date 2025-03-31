package com.hyeongkyu.template.global.error;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.Getter;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName   : com.hyeongkyu.template.global.error
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 31.
 * Description   :
 */
@Getter
public class ArgumentNotValidExceptionDto extends ExceptionDto {

    private final Map<String, String> errorFields;

    public ArgumentNotValidExceptionDto(final MethodArgumentNotValidException methodArgumentNotValidException) {
        super(ErrorCode.INVALID_INPUT_VALUE);

        this.errorFields = new HashMap<>();
        methodArgumentNotValidException.getBindingResult()
                .getAllErrors().forEach(e -> this.errorFields.put(((FieldError) e).getField(), e.getDefaultMessage()));
    }

    public ArgumentNotValidExceptionDto(final ConstraintViolationException constraintViolationException) {
        super(ErrorCode.INVALID_INPUT_VALUE);

        this.errorFields = new HashMap<>();

        for (ConstraintViolation<?> constraintViolation : constraintViolationException.getConstraintViolations()) {
            errorFields.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }
    }
}

