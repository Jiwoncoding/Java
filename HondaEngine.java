package com.icia.spring.example06.engine;

import lombok.*;

@ToString
public class HondaEngine implements Engine {
	@Override
	public String getEngineName() {
		return "혼다 엔진";
	}
}
