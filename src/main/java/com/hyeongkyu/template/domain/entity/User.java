package com.hyeongkyu.template.domain.entity;

import com.hyeongkyu.template.domain.dto.request.SignUpRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName   : com.hyeongkyu.template.domain.entity
 * Author        : imhyeong-gyu
 * Data          : 2025. 9. 15.
 * Description   :
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serial_id", nullable = false, unique = true)
    private Long serialId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "is_login", columnDefinition = "TINYINT(1)")
    private Boolean isLogin;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public User(Long serialId) {
        this.serialId = serialId;
        this.isLogin = true;
    }

    public static User signUpByRequest(SignUpRequest request) {
        return User.builder()
                .serialId(request.providerId())
                .email(request.email())
                .nickname(request.nickName())
                .isLogin(false)
                .build();
    }

}
