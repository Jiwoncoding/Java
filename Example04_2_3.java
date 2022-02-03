package com.icia.spring.example04_2.test;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import com.icia.spring.example03.mart.*;
import com.icia.spring.example03.seller.*;

// 스프링 DI는 타입 기반(by type)으로 움직인다. 필요한 경우 이름 기반으로 지정할 수 있다
public class Example04_2_3 {
	@Test
	public void testRun() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/icia/spring/example04_2/test/context2.xml");
		
		// 타입으로 검색하면 결과는 그 타입, 그런데 이름으로 검색하면 결과는 Object
		Seller seller = (Seller)ctx.getBean("squidSeller");
		Mart mart = new Mart(seller);
		mart.doSell();
	}
}
