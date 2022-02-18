package zboard_lambda;

// 작업 할 때 반복되는 코드 : boilerplate(보일러플레이트)
// 자바에서 js처럼 함수를 파라미터로 넘기고 싶다. 근데 자바는 인터페이스를 구현한 객체를 생성해야 한다 -> 보일러플레이트를 제거하자

public class Test3 {
	public static void main(String[] args) {
		// Runnable은 만들어야 하는데...클래스까지 만들 필요는 없잖아...파라미터로 Runnable을 넘기자
		
		// Thread 생성자의 파라미터가 Runnable이라는 사실을 자바가 알고 있다
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("익명 객체를 이용한 스레드");
			}
		}).start();
		
		// 그렇다면 프로그래머는 run()의 내부만 만들자 -> 객체는 자바가 만들면 되잖아 : 자바 Lambda
		// 메소드만 만들면 자바가 객체를 알아서 생성해준다 -> 전제조건 : 인터페이스가 존재해야만 한다
		new Thread(
			()->{System.out.println("익명 객체를 이용한 스레드");}
		);
	}
}
