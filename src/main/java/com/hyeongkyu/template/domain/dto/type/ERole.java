package com.hyeongkyu.template.domain.dto.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * packageName   : com.hyeongkyu.template.domain.dto.type
 * Author        : imhyeong-gyu
 * Data          : 2025. 9. 15.
 * Description   :
 */

@RequiredArgsConstructor
@Getter
public enum ERole {
    GUEST("GUEST", "ROLE_GUEST"),
    USER("USER", "ROLE_USER"),
    ;

    private final String name;
    private final String securityName;

    public static ERole fromName(String name) {
        return Arrays.stream(ERole.values()).
                filter(role -> role.getName().equals(name))
                .findFirst().orElseThrow(IllegalAccessError::new);
    }
}
