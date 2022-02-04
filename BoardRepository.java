package com.icia.spring.example09.repository;

import org.springframework.stereotype.Component;

// 이 클래스는 component-scan의 작업 대상이고 스프링 빈으로 관리될 것이다
// 이름을 지정하지 않으면 기본 이름은 첫글자만 소문자로 바꾼 것 -> boardRepository
@Component
public class BoardRepository {
	// 데이터베이스 CRUD 작업을 수행
	// 스프링 빈 : controller, service, repository 클래스
}
