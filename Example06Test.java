package com.icia.spring.example06.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icia.spring.example06.car.Car;

public class Example06Test {
	@Test
	public void testRun() {
		// 제조사는 현대, 엔진은 르노엔진, 가격인 10000000원인 자동차를 ApplicationContext에서 꺼내시오
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/icia/spring/example06/test/context.xml");
		Car car = ctx.getBean(Car.class);
		car.introduce();
	}
}
