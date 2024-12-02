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
/*
Controller에서 Service, Service에서 Repository.. 로 연결
 */
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public long createPost(@RequestBody PostRequest postRequest) {
        log.info(postRequest.getTitle());
        log.info(postRequest.getAuthor());
        log.info(postRequest.getContent());
        log.info(postRequest.getPassword());
        /*
        log.info()
        로그를 기록할 때 사용되는 메소드. 잘 실행됐는지 볼라고 하는거임.
        */

        // 이건 왜 있더라?
        long id = postService.createPost(postRequest);

        // 마지막으로는 id (몇 번째인지) 반환
        return id;
    }
}
