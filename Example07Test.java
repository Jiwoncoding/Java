package com.icia.spring.example07.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.icia.spring.example07.theater.Theater;

// 지금까지 DI 이해를 위해 ApplicationContext를 수동으로 만들고 수동으로 getBean했다
// 이제부터는 스프링 프레임워크가 설정 파일을 읽어 자동으로 작업이 진행되도록 하자

// JUnit이 스프링 DI 컨테이너를 이용해 테스트를 진행하자
// JUnit은 자바 테스트 도구 -> 테스트 대상을 변경하는 것이 가능하다
// 구글링하면 Junit4 코드가 많이 나올텐데...작성법이 다르다
@ExtendWith(SpringExtension.class)
// 스프링 설정파일의 위치를 지정 : 스프링 컨테이너 == context
@ContextConfiguration(locations = "file:src/com/icia/spring/example07/test/context.xml")
public class Example07Test {
	// DI를 하는 방법 : 생성자 주입, 세터 주입, 필드 주입
	@Autowired
	private Theater theater;
	
	@Test
	public void testRun() {
		theater.show();
	}
}
