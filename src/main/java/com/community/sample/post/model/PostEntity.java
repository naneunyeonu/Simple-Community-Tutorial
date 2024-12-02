package com.community.sample.post.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Entity
@Table(name = "Post")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 자습
    /*
    @GeneratedValue -> 기본 키 값을 자동으로 생성할 방식을 설정하는 어노테이션
    strategy속성 -> 생성전략 지정
    enerationType.IDENTITY -> 기본 키를 자동 증가(auto-increment)방식으로 생성
                            새 레코드가 삽입될 때마다 DB가 기본 키를 자동으로 증가시키고,
                            그 값을 엔티티 객체의 id필드에 설정.
                            (MySQL, PostgreSQL등에서 사용하는 자동증가와 동일함.

    Model -> DB, 비즈니스 로직과의 상호작용을 담당하는 객체
            앱의 실제 비즈니스 데이터와 DB Table(데이터 구조)을 표현함
     */
    private Long id; // ID식별 -> DB에서 자동으로 증가하는 값.
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "password")
    private String password;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();
    @Column(name = "updated_at")
    private OffsetDateTime updateAt;

}
