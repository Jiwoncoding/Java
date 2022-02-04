package com.icia.spring.example09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icia.spring.example09.repository.BoardRepository;

// 서비스 클래스는 Repository를 주입받고 실제 업무를 수행하는 클래스
@Component
public class BoardService {
	// 여기가 원래는 인터페이스여야 합니다(100% 각잡고 만들면....) -> 인터페이스, 클래스가 같이 존재해서 패키지가 복잡해지단
	// 일반저인 업무용 프로그램의 경우 BoardRepository 인터페이스가 있을 때 구현 클래스가 하나만 있는 경우가 많다
	// 그러다 보니 인터페이스 없이 (약간 야매로) 클래스로 바로 작업하는 경우도 꽤 있다 
	@Autowired
	private BoardRepository boardRepository;
}
