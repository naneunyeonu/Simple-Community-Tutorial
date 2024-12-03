package com.community.sample.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 아래의 어노테이션은 lombok에서 제공함
@Data
/*
@Data -> Getter, Setter 등의 기능들을 자동생성,,
 */
@NoArgsConstructor
// 인자가 없는 기본 생성자를 자동으로 생성함
@AllArgsConstructor
// 모든 필드를 받는 생성자를 자동으로 생성함
// No, All을 같이 쓰면 기본 생성자와 모든 필드를 받는 생성자를
// 동시에 자동으로 생성 가능
/*
    API의 입,출력을 다룸

    DTO(Data Transfer Object) -> 데이터 전달 객체
                                Client<->Server 간의 Data 교환
                                내용으로 Data의 종류(?)가 들어감
 */
public class PostRequest {

    private String title;
    private String author;
    private String content;
    private String password;

}
