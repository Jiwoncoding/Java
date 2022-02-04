package com.icia.spring.example07.performer;

import lombok.*;
import lombok.extern.slf4j.*;

@Slf4j
@Setter
public class Singer implements Performer {
	private String song;
	@Override
	public void perform() {
		log.info(song + "을 부릅니다");
	}
}
