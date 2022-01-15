package javaex;

import java.time.*;

// Thread : 메소드를 병렬 실행하는 것
// 자바에서 만들려면 메소드를 병렬실행하면 된다
//		그러면 내가 메소드를 작성한 다음 자바에게 병렬실행하라고 알려준다???
//		아니면 병렬 실행할 메소드의 이름을 자바가 정해준다??? -> O -> run

class MyThread implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(i);
		}
	}	
}

public class 스레드Test1 {
	public static void main(String[] args) {
		System.out.println("========== 메인 시작 =========");
		new Thread(new MyThread()).start();
		System.out.println("========== 메인 종료 =========");
	}
}
