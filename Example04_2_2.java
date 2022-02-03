package com.icia.spring.example04_2.test;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import com.icia.spring.example03.seller.*;

public class Example04_2_2 {
	// 요청한 빈을 ApplicationContext가 2개 이상 가지고 있을 때의 예외 메시지 : NoUniqueBean~
	@Test
	public void testRun() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/icia/spring/example04_2/test/context.xml");
		
		// ctx는 SquidSeller, CupSeller 두 빈을 가지고 있고 둘 모두 Seller 객체
		// getBean을 할 때 스프링이 둘 중 어느 빈을 꺼내야 할 지 판단할 수가 없다 
		Seller seller = ctx.getBean(Seller.class);
		
		// 여기서 알 수 있는 점
		// ApplicationContext에서 빈을 찾을 때 이름으로 찾는 것이 아니라 타입으로 찾는다
		// 찾는 타입의 빈이 없으면 -> NoSuchBean~Exception
		// 찾는 타입의 빈이 2개 이상이면 -> NoUniqueBean~Exception
		
		// 그러면 이름으로 찾을 수 없을까?
		
	}
}
