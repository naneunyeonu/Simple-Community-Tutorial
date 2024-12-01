package com.community.sample.post.service;

import com.community.sample.post.dto.PostRequest;
import com.community.sample.post.model.PostEntity;
import com.community.sample.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
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
