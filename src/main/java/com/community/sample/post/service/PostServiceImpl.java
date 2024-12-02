package com.community.sample.post.service;

import com.community.sample.post.dto.PostRequest;
import com.community.sample.post.model.PostEntity;
import com.community.sample.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
/*
비즈니스 로직을 처리하는 서비스 클래스 정의 시에 사용됨
@Service를 붙임으로써 자동으로 Spring의 Bean으로 등록,
의존성 주입(Dependency Injection)을 통해
다른 클래스에서 쉽게 사용할 수 있음
 */
@RequiredArgsConstructor
/*
final 필드나 @NonNull이 붙은 필드에 대해 자동으로 생성자를 생성해줌
주로 의존성 주입을 위해 생성자 주입 방식을 사용할 때 유리함
 */

// Service 구현체 (Impl 클래스)
// Impl은 Implementation의 약자, 인터페이스를 구현하는 클래스에 붙이는 접미사
public class PostServiceImpl implements PostService {
    // implements를 사용하는 이유
    // PostService 인터페이스를 본 클래스에서 구현하기 위함

    // 의존성 주입, RequiredArgsConstructor 덕분에
    // 생성자가 필요하지 않음
    private final PostRepository postRepository;

    @Override
    public long createPost(PostRequest postRequest) {
        // PostEntity 만들기
        PostEntity postEntity = PostEntity.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .author(postRequest.getAuthor())
                .password(postRequest.getPassword())
                // 수정일시는 필요 없으니 NULL 맞음
                .createdAt(OffsetDateTime.now())
                .build();

        PostEntity newEntity = postRepository.save(postEntity);

        long newId = newEntity.getId();

        return newId;
    }
}
