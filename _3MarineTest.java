package com.icia.example11;

import org.apache.commons.lang3.*;

// 마린을 생성할 때 랜덤한 이름이 붙는다
class Marine3 {
	// 객체마다 다른 값은 인스턴스 초기화 불가능
	String name;
	int hp = 40;
	int kill = 0;
	int attack = 6;
	
	// 객체마다 필드값을 다르게 하는 방법 - 생성자를 사용한다
	// 생성자는 리턴이 없고, 이름은 클래스 이름과 같다
	public Marine3() {
		// 알파벳으로 구성된 10글자 랜덤 문자열
		RandomStringUtils.randomAlphabetic(10);
		// 알파벳과 숫자로 구성된 10글자 랜덤 문자열
		name = RandomStringUtils.randomAlphanumeric(10);
	}
}
public class _3MarineTest {
	public static void main(String[] args) {
		Marine3 m1 = new Marine3();
		Marine3 m2 = new Marine3();
		System.out.println(m1.name);
		System.out.println(m2.name);
		
		m1.name = "홍길동";
		System.out.println(m1.name);
	}
}
