package com.icia.spring.example06.engine;

import lombok.*;

@ToString
public class RenaultEngine implements Engine {
	@Override
	public String getEngineName() {
		return "르노 엔진";
	}
}