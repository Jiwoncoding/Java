package zboard_lambda;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

// 입력이 있고 출력은 boolean -> 조건 체크. 우리 프로젝트에서 사용할 일을 아마 없을 거 같다
class SamplePredicator implements Predicate<Integer> {
	@Override
	public boolean test(Integer t) {
		return t%2==0;
	}
}

public class Test6 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,22,33,44,55);
		
		// 람다식을 이용해 작업하도록 만들어진 자바 기술이 Java Stream API
		// 리스트를 스트림을 변환하면 자바가 제공하는 함수를 이용해 람다식을 연속으로 사용할 수 있다
		// filter는 list를 모든 원소를 차례로 입력받아 조건을 만족하는 것만 걸러낸다
		// 스트림에는 메소드에는 중간에서 필터링 또는 변경하는 중간 메소드가 있고 최종 소비를 하는 메소드가 있다
		list.stream().filter(a->a%2==0).forEach(System.out::println);
		
		// list로 부터 조건을 만족하는 원소만 뽑아서 리스트를 작성하고 싶다면
		List<Integer> result = list.stream().filter(a->a%2==0).collect(Collectors.toList());
		
		System.out.println(list.stream().filter(a->a%2==0).count());
	}
}








