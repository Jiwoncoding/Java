package com.icia.spring.example09.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.icia.spring.example09.controller.BoardController;

@ExtendWith(SpringExtension.class) 
@ContextConfiguration(locations ={"file:src/com/icia/spring/example09/test/context.xml"})
public class Example09Test {
	// 스프링 웹 프로젝트는 3개의 클래스로 나누어지는 것이 일반적
	// Controller : 사용자 입출력. Service 클래스에 의존
	// Service : 실제 작업. Repository 클래스에 의존
	// Repository : 작업결과를 데이터베이스에 입출력하는 클래스
	@Autowired
	private BoardController boardController;
	
	@Test
	public void testRun() {
		System.out.println(boardController);
	}
}
