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
// Simple Logging Facade for Java
// 로깅을 위한 Logger 객체를 자동으로 생성해주는 기능을 제공
@RestController
// @Controller 와 @ResponseBody 의 결합
// 컨트롤러 역할 + HTTP 응답 본문에 데이터를 반환하는 기능
// JSON, XML 형식의 데이터를 주고받는 HTTP API를 설계할 때 유용함
@RequestMapping("/api/v1/post")
// HTTP메소드(GET, POST, PUT, PATCH, DELETE..)에 대한 요청을 매핑하게 해줌
// api/v1/post 경로로 들어오는 모든 HTTP 요청을 createPost메소드로 처리하게 매핑함
@RequiredArgsConstructor // bean 같은걸 알아서 넣어줌
// final 필드나 @NonNUll 필드에 대해 생성자를 자동으로 생성해 줌

// POST 에서의 대략적 흐름
// Controller에서 Service, Service에서 Repository.. 로 연결
public class PostController {
    private final PostService postService;

    @PostMapping("")
    // HTTP POST 요청을 처리하는 매핑 어노테이션
    // @RequestMapping의 축약형
    // 새로운 자원 생성, Client가 보낸 데이터를 서버에서 처리하는 API 엔드포인트 구현 시 사용
    // Ex.) 회원가입, 글 작성, 데이터 전송.....
    // @PostMapping("") --> 루트 경로(/)에 대한 POST 요청을 처리함ㅌ₩₩ㅌ
    public long createPost(@RequestBody PostRequest postRequest) {
        log.info(postRequest.getTitle());
        log.info(postRequest.getAuthor());
        log.info(postRequest.getContent());
        log.info(postRequest.getPassword());
        /*
        log.info()
        로그를 기록할 때 사용되는 메소드. 잘 실행됐는지 볼라고 하는거임.
        위의 @SLf4j 어노테이션 덕에 쓸 수 있음
        */

        // 이건 왜 있더라?
        long id = postService.createPost(postRequest);

        // 마지막으로는 id (몇 번째인지) 반환
        return id;
    }
}
