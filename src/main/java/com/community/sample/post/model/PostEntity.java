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
    private Long id;
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
