package com.icia.example11;

import org.apache.commons.lang3.*;

// 이름을 붙이면 그 이름, 안붙이면 랜덤 문자열
// 객체를 생성할 때 -> 생성자. 
// 이름을 붙일 수도 있고 안 붙일 수도 있다 -> 파라미터가 다르다 
// 파라미터가 다르면 함수이름이 같아도 된다 -> overload
class Marine4 {
	String name;
	int hp = 40;
	int kill = 0;
	int attack = 6;
	
	public Marine4() {
		name = RandomStringUtils.randomAlphabetic(10);
	}
	
	public Marine4(String name) {
		this.name = name;
	}
}
public class _4MarineTest {

}
