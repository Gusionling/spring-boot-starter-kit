package com.hyeongkyu.template.controller;

import com.hyeongkyu.template.global.common.ResponseDto;
import com.hyeongkyu.template.global.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName   : com.hyeongkyu.template.controller
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 31.
 * Description   :
 */

@RestController
@RequestMapping(Constants.API_PREFIX + "/health")
@Slf4j
public class HealthCheckController {

    @GetMapping
    public ResponseDto<?> healthCheck() {
        return ResponseDto.ok("health check");
    }

}
