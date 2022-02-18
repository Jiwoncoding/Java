package zboard_lambda;

// 스레드 : 메소드가 병렬 실행
// 스레드가 실행될 때 윈도우로 부터 일정 실행시간을 지정받는다(time slice). 시간이 지나면 실행을 양보한다
// 만약 2초 걸리는 A스레드, 3초 걸리는 B 스레드가 있다면. 그리고 타임 슬라이스가 0.1초라면
// A		B		A			B
// 0.1		0.1		0.1(0.2)	0.1(0.2).....

// 자바는 스레드 클래스를 제공하기 때문에 간단하게 병렬 작업을 할 수 있다
// 단 자바가 병렬로 돌릴 작업이 뭔지는 모른다 --> 프로그래머가 작성해야 한다 --> 이름이 run으로 정해져 있다

// 자바에서 표준메소드를 작성하려면 인터페이스를 implements해야 한다
class MyRunnable implements Runnable {
	@Override
	public void run() {
		for(int i=1; i<=10; i++)
			System.out.println("### MyRunnable 실행 중 : " + (i*10) + "% 완료 ###");
	}
}

public class Test2 {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		
		// new Thread하는데 왜 객체를 넘긴다? 실제로는 메소드를 넘긴 것
		// 	js에서는 함수만 넘길 수 있다. new Thread(function() { });
		new Thread(myRunnable).start();
		System.out.println("메인 스레드 종료");
	}
}






