package com.icia.spring.example07.theater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.icia.spring.example07.performer.Performer;

import lombok.extern.slf4j.Slf4j;

// 극장이 있고 극장에서 공연하는 공연자(Performer)가 있다
// context.xml에서 생성자 주입을 이용해 Juggler 객체를 등록, 세터 주입을 이용해 Singer 객체를 등록
// 또 Theater 객체를 생성해라(라이프사이클 메소드 open, close를 지정)

@Slf4j
public class Theater {
	// 필드 주입 : ApplicationContext가 Performer에 해당하는 객체를 주입해준다
	// @Autowired는 타입을 가지고 DI한다
	@Autowired
	// 만약 이름(id)으로 DI하려면 @Qualifier를 사용한다
	@Qualifier("juggler")
	private Performer performer;
	
	public void open() {
		log.info("공연을 시작합니다. 막이 올라갑니다");
	}
	
	public void show() {
		performer.perform();
	}
	
	public void close() {
		log.info("공연이 끝났습니다");
	}
}
