package com.icia.spring.example06.car;

import com.icia.spring.example06.engine.*;

import lombok.*;
import lombok.extern.slf4j.*;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	private String vendor;
	
	// 인터페이스에 의존. 인터페이스 구현 클래스를 마음대로 바꿔 끼면서 자동차를 조립할 수 있다 -> 전략 패턴
	// 전략 패턴에서 구현체를 바꿔가면서 작업하는 것에 초점을 두는 것이 아니라 구현체를 외부에서 공급한다에 초점을 맞추면 DI
	private Engine engine;
	private int price;
	public void introduce() {
		log.info("{}", this.toString());
	}
}
