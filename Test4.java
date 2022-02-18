package zboard_lambda;

// 람다식을 이용해 간편하게 함수를 작성하려면...많은 작업이 필요하다

// 람다식을 사용하려면 추상 메소드를 하나가진 인터페이스가 바람직
@FunctionalInterface
interface 인사 {
	public void hello();
}

class 학생 {
	public void 꾸벅(인사 insa) {
		insa.hello();
	}
}

public class Test4 {
	public static void main(String[] args) {
		// 인터페이스가 있고 그 인터페이스를 이용하는 클래스가 있어야만 람다식을 사용할 수 있다
		// 람다를 사용하려니 배보다 배꼽이 크다 -> 자바는 java.util.function 패키지를 이용해 FunctionInterface를 제공
		학생 s = new 학생();
		s.꾸벅(()->{ System.out.println("안녕하세요"); });
	}
}
