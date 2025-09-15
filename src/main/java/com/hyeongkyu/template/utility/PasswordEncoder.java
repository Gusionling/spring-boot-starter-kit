package com.hyeongkyu.template.utility;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * packageName   : com.hyeongkyu.template.utility
 * Author        : imhyeong-gyu
 * Data          : 2025. 9. 15.
 * Description   :
 */

@Service
@RequiredArgsConstructor
public class PasswordEncoder {

    private final BCryptPasswordEncoder customPasswordEncoder;

    public String encode(String password) {
        return customPasswordEncoder.encode(password);
    }

    public boolean matches(String password, String encodedPassword) {
        return customPasswordEncoder.matches(password, encodedPassword);
    }
}
