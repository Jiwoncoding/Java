package com.icia.example11;

// 마린으로 기능들도 클래스에 추가하자 -> 서로 관련된 데이터+기능 
class Marine2 {
	// 클래스 멤버 : 값(필드) + 기능(method)
	// 필드는 초기화하지 않으면 값이 0이다
	// 필드를 만들면서 바로 초기화 - 인스턴스 초기화
	int hp = 40;
	int kill = 0;
	int attack = 6;
	public void 공격() {
		System.out.println("공격력 " + attack + "으로 공격합니다");
	}
	public void 스팀팩() {
		if(hp>10) {
			hp-=10;
			attack+=2;
		}
	}
	public void death() {
		if(hp<=0)
			System.gc();		// 자바의 메모리 회수기능을 요청(garbage collection)
	}
}
public class _2MarineTest {
	public static void main(String[] args) {
		Marine2 m1 = new Marine2();
		Marine2 m2 = new Marine2();
		m1.공격();
		m2.공격();
	}
}
