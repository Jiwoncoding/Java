package com.icia.example8;

import java.time.*;

// 도시락은 날짜를 가진다 -> HAS_A 관계
// A는 B를 가진다 -> A는 B에 의존한다(dependency)
class 도시락 {
	// 생산일자, 유통기한을 가진다
	LocalDate productDay;
	LocalDate validDay;
}

// 학생 클래스와 사람 클래스가 있다 -> 어떤 관계?? A is_a B, A has_a B
// 학생은 사람이다	(O)
// 사람은 학생이다
// 학생은 사람을 가진다
// 사람은 학생을 가진다

// 학생 클래스와 휴대폰 클래스가 있다
// 학생은 휴대폰이다
// 휴대폰은 학생이다
// 학생은 휴대폰을 가진다 (O)
// 휴대폰은 학생을 가진다

public class Test2 {

}
