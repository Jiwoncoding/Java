package com.icia.spring.example04_2.test;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import com.icia.spring.example03.mart.*;
import com.icia.spring.example03.seller.*;

// Mart를 꺼내자
public class Example04_2_4 {
	@Test
	public void testRun() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/icia/spring/example04_2/test/context3.xml");
		
		// 아래 코드를 xml로 표현하자
		// Mart mart = new Mart(seller);
		
		Mart mart = ctx.getBean(Mart.class);
		mart.doSell();
	}
}
