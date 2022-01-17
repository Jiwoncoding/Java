package com.icia.example10;

// stack, heap : 개념
// heap : 필요할 때 필요한 만큼 사용 후 반납 -> 객체
// stack : 문법에 따라 자바가 운영하는 자동 메모리(auto) -> 메소드, 지역변수
//		지역변수의 정의는 메소드 소속의 변수
//		메소드는 객체소속이지만 힙에 안올리고 뜯어내서 스택에  위치. 이유가 뭐지?

// queue - 선착순(FIFO, Fist In First Out)
//		버튼을 더블 클릭하면 이벤트는 버튼 클릭 -> 버튼 더블클릭 순으로 발생한다
// stack - 선착순의 반대(LIFO, Last In First Out)
class Sample2 {
	public void func1(int a) {
		System.out.println("함수 1 호출");
		if(a%2==0) 
			System.out.println(func2());
		else
			System.out.println(func3());
	}
	public Integer func2() {
		System.out.println("함수 2 호출");
		return 3;
	}
	public Integer func3() {
		System.out.println("함수 3 호출");
		return 3333;
	}
	public void func4() {
		System.out.println("함수 4 호출");
		System.out.println(func2());
		System.out.println("함수 4 종료");
	}
}
public class _2StackTest {
	public static void main(String[] args) {
		Sample2 ob = new Sample2();
		int a = 10;
		ob.func1(a);
		System.out.println("=====================================");
		ob.func4();
	}
}
