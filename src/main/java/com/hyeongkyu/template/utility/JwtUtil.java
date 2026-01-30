package com.hyeongkyu.template.utility;

import com.hyeongkyu.template.domain.dto.type.ERole;
import com.hyeongkyu.template.global.constants.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;


/**
 * packageName   : com.hyeongkyu.template.utility
 * Author        : imhyeong-gyu
 * Data          : 2025. 9. 15.
 * Description   : 토큰 관련한 클래스이다. 토큰을 실질적으로 생성하고 검증하는 곳이라고 보면된다.
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.access-token-expire-period}")
    private Integer accessTokenExpirePeriod;

    @Getter
    @Value("${jwt.refresh-token-expire-period}")
    private Integer refreshTokenExpiredPeriod;

    private Key key;

    /*일반 생성자를 쓰면 secretKey 를 주입 받기 전에 빈이 생성이 되어버린다.*/
    @PostConstruct
    public void init(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    /*파라미터의 토큰을 우리가 지정한 키로 검증을 하는 부분이다. 검증이 완료되면 클레이(페이로드)를 추출한다.*/
    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody(); // 클레임(페이로드) 추출
    }

    /*jwt 토큰을 만드는 함수이다. 클레임을 만들고 builder로 생성을 하면된다.*/
    private String generateToken(Long id, ERole role, Integer accessTokenExpirePeriod) {
        Claims claims = Jwts.claims();
        //Map을 extend한 인터페이스라는 것을 할 수 있다. -> Map 메서드들을 사용할 수 있음
        claims.put(Constants.USER_ID_CLAIM_NAME, id);
        if (role != null) {
            claims.put(Constants.USER_ROLE, role);
        }

        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }







}
