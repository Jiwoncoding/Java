package zboard_lambda;

public class Test1 {
	public static void main(String[] args) {
		// Gang of Four(GoF)가 디자인 패턴
		// ~Factory : 객체를 생성하는 데 복잡한 옵션이나 정보가 필요. 대신 설정해 주는 클래스
		
		// MyBatis의 경우 DataSource를 입력받아 SqlSession을 생성한 다음 SqlSession을 이용해 CRUD 처리
		
		// active시 최대 연결은 몇개? idle시 최대 연결 몇개? 타임아웃시간?.....설정을 잡을 수 있는데
		// 설정을 안잡으면 SqlSession을 안만들건가?  적절하게 초기화해서 객체를 만들어주는 공장 -> Factory
		
		// 마이바티스의 SqlSessionFactory는 DataSource를 입력받아 SqlSession을 편리하게 사용할 수있는
		// SqlSessionTemplate을 만들어준다
		
		// ~Builder : 객체 생성의 난해함(예를들어 필드가 String 10개)을 덜어준다
		
		// Facade : 표준 인터페이스 + 인터페이스를 구현한 구상(concrete) 클래스
		//			표준을 가지고 작업을 하면 구상 클래스를 필요에 따라 교체하면서 사용
	
	}
}
