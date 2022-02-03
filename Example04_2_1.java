package com.icia.spring.example04_2.test;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import com.icia.spring.example03.mart.*;

public class Example04_2_1 {
	// 요청한 빈을 ApplicationContext가 가지고 있지 않을 때의 예외 메시지 : NoSuchBean~Exception
	@Test
	public void testRun() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/icia/spring/example04_2/test/context.xml");
		Mart mart = ctx.getBean(Mart.class);
		mart.doSell();
	}
}
