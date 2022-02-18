package zboard_lambda;

import java.util.*;
import java.util.function.*;

class SupplierSample1 implements Supplier<Integer> {
	@Override
	public Integer get() {
		// 입력은 없고 출력은 있다
		return 1;
	}
}

// 우리가 사용할 서플라이어 형식 : 
class SupplierSample2 implements Supplier<RuntimeException> {
	@Override
	public RuntimeException get() {
		return new RuntimeException();
	}
}

public class Test7 {
	public static void main(String[] args) {
		// java.util.Optional : NullPointerException에 대한 자바의 대응
		//	리턴값이 반드시 존재할 경우  :  public User searchUser(String username) { }
		// 리턴값이 존재하지 않을 수 있는 경우 : public Optional<User> searchUser(String username) { }
		
		// dao에서 Optional로 result가 리턴되어 왔다고 하자
		Optional<Integer> result = Optional.ofNullable(null);
		
		// result에 들어있을 수 있는 Integer를 꺼내려면 get() -> 단 값이 없으면 NoSuchElementException 예외 발생
		// Integer value1 = result.get();
		
		// 예외를 내가 원하는 예외로 바꿔주자
		// 스프링에는 예외를 전담하는 컨트롤러가 있다(@ControllerAdvice)
		// 검색 실패와 같이 내가 원하지 않는 결과가 나왔을 때 적절한 예외를 발생시켜 ControllerAdvice를 부르자
		// 즉 작업을 할 때 바람직한 상황은 Controller에 작성, 원하지않는 상황은 ControllerAdvice에 작성하자
		result.orElseThrow(()->new RuntimeException());
		
		result.orElseThrow(RuntimeException::new);
		
	}
}









