package javaex;

// 부모클래스는 자식 클래스가 구현해야 할 메소드의 이름을 지정한다
// 부모클래스가 메소드 이름을 정했는데...어떻게 자식에게 알려주지? 추상 메소드

abstract class Tire {
	// 메소드는 반드시 {}를 가져야 한다
	// 그런데 추상 메소드의 경우 {}를 생략할 수 있다 -> 자식에게 구현을 떠넘긴다
	// 추상 메소드를 하나라도 가지면 클래스가 추상 클래스가 된다 -> 객체 생성 불가능
	public abstract void round();
}

class 브릿지스톤 extends Tire {
	public void round() {
		System.out.println("브릿지스톤 타이어가 굴러갑니다");
	}
}

// 상속에 의해 미쉐린 클래스가 추상 클래스가 됐고 오류가 발생
// 1. 클래스에 abstract를 붙여 자식에게 떠 넘긴다
// 2. 추상 메소드를 구현한다 -> 에러를 통해 자식들이 만들어야 할 메소드의 이름을 가르쳐 준다
class 미쉐린 extends Tire {

}

public class 추상클래스Test1 {

}
