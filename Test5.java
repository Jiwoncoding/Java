package zboard_lambda;

import java.util.*;
import java.util.function.*;

// Consumer FunctionalInterface : 입력은 있고 리턴은 없다
class ConsumerSample implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		System.out.println(t);
	}
}

public class Test5 {
	public static void main(String[] args) {
		// Arrays.asList는 배열을 리스트로 변환하는 함수. 읽기전용이다
		List<Integer> list = Arrays.asList(11,22,33,44,55);
		
		// ConsumerSample을 사용한 예 : ?의 구체적 의미가 궁금해서 iilii.eloos.com에서 generic 강좌를 보세요
		list.forEach(new ConsumerSample());

		
		
		// 람다식을 사용한 예
		// list.forEach((xx)->{ System.out.println(xx); });
		
		// 처리하는 코드가 한 줄이면 {}를 생략할 수 있다. {}를 생략하면 ;이 오면 안된다 
		//list.forEach((xx)->System.out.println(xx));
		
		// 파라미터가 하나면 ()를 생략할 수 있다(하나일때만 생략 가능)
		//list.forEach(a->System.out.println(a));
		
		// 파라미터에 대해 어떤 처리도 하지 않는다면....윗줄의 경우 xx가 들어와서 그대로 xx를 출력한다...생략하자
		// 이렇게 파라미터를 생략하고 함수를 사용하는 것을 "메소드 참조"라고 한다
		list.forEach(System.out::println);
		
	}
}



