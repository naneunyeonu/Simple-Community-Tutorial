package com.community.sample.post.controller;

import com.community.sample.post.dto.PostRequest;
import com.community.sample.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor // bin 같은걸 알아서 넣어줌
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public long createPost(@RequestBody PostRequest postRequest) {
        log.info(postRequest.getTitle());
        log.info(postRequest.getAuthor());
        log.info(postRequest.getContent());
        log.info(postRequest.getPassword());
        long id = postService.createPost(postRequest);

        return id;
    }
}
