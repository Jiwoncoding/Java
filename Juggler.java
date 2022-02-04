package com.icia.spring.example07.performer;

import org.springframework.beans.factory.annotation.Value;

import lombok.*;
import lombok.extern.slf4j.*;

@Slf4j
@AllArgsConstructor
public class Juggler implements Performer {
	@Value("3")
	private int ball;
	@Override
	public void perform() {
		log.info(ball + "개의 공으로 저글링합니다");
	}
}
