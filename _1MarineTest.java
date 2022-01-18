package com.icia.example11;

// 관련된 정보들을 모아서 정보 덩어리를 만들자 -> 재사용이 쉬워진다
class Marine1 {
	int hp;
	int kill;
	int attack;
}
public class _1MarineTest {
	public static void main(String[] args) {
		int hp1, hp2, hp3;
		int kill1, kill2, kill3;
		int attack1, attack2, attack3;
		Marine1 m1 = new Marine1();
		Marine1 m2 = new Marine1();
		
		if(m1.hp==0) {
			delete m1;
		}
		if(m1.kill>100) {
			m1.attack++;
		}
	}
}
