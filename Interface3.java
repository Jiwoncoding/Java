package javaex;

// 온라인 게임을 만든다고 하자
// A부서 : 간단한 일상대화 번역프로그램
//		  번역기능을 표준을 만들어서 외부에 공지
//		   String translate(String from, String to, String msg)
//		   translate("kor", "eng", "hello") -> 안녕
interface Translator {
	public String translate(String from, String to, String msg);
}
class KorToEng implements Translator {
	@Override
	public String translate(String from, String to, String msg) {
		return null;
	}
}
class KorToChn implements Translator {
	@Override
	public String translate(String from, String to, String msg) {

		return null;
	}
}


// B부서 : A부서의 프로그램을 이용해 채팅 기능 개발
class Chat {
	private Translator translator = new KorToEng();
	
}

public class 인터페이스Test3 {

}