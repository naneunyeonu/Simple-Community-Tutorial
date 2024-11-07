package com.community.sample.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* 
 * TestController가 RESTful 웹 서비스를 제공하는 컨드롤러임을 나타냄 
 * @Controller @ResponseBody가 결합된 형태,
 * 메소드의 반환값을 JSON. XML 등으로 자동 변환해 HTTP응답 본문에 포함시킴
 * 클라이언트가 보낸 요청에 대한 응답을 반환하는 역할을 함
 * 
 * REST(Representational State Transfer)
 * 웹에서 데이터를 주고받기 위한 아키텍처 스타일
 * HTTP프로토콜을 사용하여 Client, Server 간의 통신 수행
 * API를 설계하는 방법을 제공함
 */

@RequestMapping("api/v1/test")
/* 클래스 내에서 처리하는 기본 URL 경로를 정의함.
 * HTTP 요청이 들어오면 해당 URL 경로로 매핑됨
 * 위의 경로는 기본 경로임.
 * 
 * Mapping
 * 일반적으로 두 개의 객체, 데이터, 또는 개념을 서로 연결하거나
 * 대응시키는 과정을 의미
 * 프로그램이나 데이터 구조에서 서로 다른 형태의 데이터를 연결, 변환하는데 사용
 * ex) URL, DB, API, 객체 Mapping 등에서 쓰임
 * 
 * URL Mapping
 * 웹 애플리케이션에서 URL과 특정 핸들러(OR Controller 메소드)를 연결하는 작업
 * 
 * "api/v1/test"
 * "(API와 관련된 경로임을 나타냄)/API 버전/특정 리소스나 기능"
 */
public class TestController {
    @GetMapping("/test")
    /*
     * HTTP GET (웹 서버에서 데이터를 가져오기 위한 HTTP매소드 중 하나) 
     * 요청을 처리하는 메소드
     * /test 는 GET 요청을 받을 경로
     */
    public String test() {
        /*
         * GET 요청에 대해 문자열 반환
         * Spring 에서 이 문자열을 HTTP 응답 본문에 자동으로 포함시켜
         * 클라이언트에 전달함
         * @RestController 덕분에 JSON이 아니라 단순 텍스트로 반환됨
         */
        return "Hello, world!";
    }
}
