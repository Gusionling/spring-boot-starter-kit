package com.hyeongkyu.template.utility;

import com.hyeongkyu.template.global.error.CommonException;
import com.hyeongkyu.template.global.error.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * packageName   : com.hyeongkyu.template.utility
 * Author        : imhyeong-gyu
 * Data          : 2025. 9. 15.
 * Description   : 딱 봐도 header에서 뭔가 작업을 하는 클래스이다.
 */

/*해더에서 토큰을 추출하기 위한 코드라고 보면된다.*/
public class HeaderUtil {

    public static Optional<String> refineHeader(HttpServletRequest request, String header, String prefix) {
        String unpreparedToken = request.getHeader(header);

        if (!StringUtils.hasText(unpreparedToken) || !unpreparedToken.startsWith(prefix)) {
            throw new CommonException(ErrorCode.INVALID_HEADER_ERROR);

        }
        // header 명 빼고 반환
        return Optional.of(unpreparedToken.substring(prefix.length()));
    }
}
