package com.icia.example11;

import org.apache.commons.lang3.*;

// 객체지향 프로그래밍을 객체를 만들고 객체들끼리 대화하면서 작업을 구성해나간다
// 객체지향 구성요소
// 1. 캡슐화 - 클래스를 만들어라
// 2. 정보은닉 - 클래스의 세부 내용을 감춰라(보호해라)
// 3. 상속 - 부모를 상속받아 기능을 확장해라
// 4. 다형성
//		overload - 동작이 유사하다(파라미터가 다르다)면 이름을 같게 해라
//		override - 부모한테 상속받은 메소드를 자식이 다시 만들면 자식 것이 실행된다(똑같은 메소드)

class Marine5 {
	private String name;
	private int hp = 40;
	private int kill = 0;
	private int attack = 6;
	
	
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getKill() {
		return kill;
	}

	public void setKill(int kill) {
		this.kill = kill;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public String getName() {
		return name;
	}

	public Marine5() {
		name = RandomStringUtils.randomAlphabetic(10);
	}
	
	public Marine5(String name) {
		this.name = name;
	}
}

public class _5MarineTest {
	public static void main(String[] args) {
		Marine5 m1 = new Marine5();
		
		// private은 외부에서 접근할 수 없다 -> getter, setter 메소드를 사용해야 한다
		System.out.println(m1.name);
		
		System.out.println(m1.getName());
	}
}
