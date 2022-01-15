package javaex;

//인터페이스 : 추상 메소드만 가진다
//인터페이스의 첫번째 역할 - main이 아닌 서브 분류
//					  자바는 단일 상속만 지원한다(상속을 이용해 주된 카테고리를 처리)
//					  interface를 이용해 부가적인 카테고리를 처리하자

// 아래 분류에서 사람과논다라는 기능을 개에게 추가하고 싶다
// 1. 개 클래스에 사람과논다()를 추가한다 - X
// 2. 동물 클래스에 사람과논다()를 추가한다 - X
// 3. 인터페이스를 통해 사람과논다라는 부가 카테고리를 처리하자

interface Pet {
	public void 사람과논다();
}

class 동물 {
	public void walk() {
	}
}

class 사자 extends 동물 {
}
class 호랑이 extends 동물 {
}
class 개 extends 동물 implements Pet {
	@Override
	public void 사람과논다() {
		System.out.println("사람과 어울려 놉니다");
	}
}
class 하마 extends 동물 {
}



public class 인터페이스Test1 {
	public static void main(String[] args) {
		동물 animal = new 개();
		animal.walk();
		
		Pet pet = new 개 ();
		pet.사람과논다();
	}
}
