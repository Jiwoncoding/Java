package com.icia.spring.example05.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icia.spring.example05.car.Car;
import com.icia.spring.example05.tire.Tire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example5Test {
	// 실무에서는 값이나 객체를 추적하는 출력용으로는 로깅 라이브러리를 사용한다
	// 로깅 라이브러리를 위한 표준은 slf4j가 있다
	// 우리는 구현체로 logback을 사용하겠다
	// slf4j의 객체를 내가 생성해야 한다 -> @Slf4j 어노테이션을 사용하면 lombok이 생성해준다
	// 		객체이름은 log
	//@Test
	public void testRun() {
		// 출력하는 메소드마다 레벨이 있다. error > warn > info > debug > trace
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
	}
	
	@Test
	public void testRun2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/icia/spring/example05/test/context.xml");
		// 참고로 스프링 MVC의 설정 파일 : servlet-context.xml, root-context.xml
		// 스프링 부트의 설정 파일 이름은 프로젝트 이름을 따라간다. ex) Example 프로젝트 -> ExampleApplication.java
		
		Tire tire = context.getBean(Tire.class);
		
		// System.out.println("타이어 : " + tire.getTireName());
		log.info("이름 : {}", "홍길동");   // 이름 : 홍길동
		log.info("타이어 : {}", tire.getTireName());
		
		Car car = context.getBean(Car.class);
		log.info("{}", car.toString());
	}
}







