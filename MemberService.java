package com.example.demo.service;

import java.lang.reflect.Member;
import java.util.Optional;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.javamail.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.entity.Level;

import lombok.RequiredArgsConstructor;


// DI하는 방법 : 생성자 주입(@RequiredArgsConstructor), 새터 주입, 필드 주입(@Autowired) → 어떤 DI가 바람직할까? → 롬복을 이용해 생성자 주입을 하자
@RequiredArgsConstructor
@Service
public class MemberService {
	private final JavaMailSender javaMailSender;
	private final MemberDao memberDao;
	private final PasswordEncoder passwordEncoder;
	
	// 메일 보내는 메소드
	public void sendMail(String from, String to, String title, String content) throws MessagingException {
		// MIME : 이메일의 형식 -> 파일의 형식. 파일의 종류를 MIME type
		// html에서 엑셀 문서를 클릭하면 application/excel이라는 MIME 타입이 내 브라우저로 전달된다
		// 		브라우저는 윈도우에서 엑셀을 찾아서 있으면 엑셀을 실행 -> 엑셀 문서가 열린단
		//		엑셀이 없으면 즉 application/excel이란 마임 타입이 알 수 없는 타입이라면 다운로드
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(title);
		helper.setText(content, true);
		javaMailSender.send(message);;
	}
	
	// 아이디 사용여부 확인
	public Boolean idAvailableCheck(String username) {
		// existsById는 null이 발생하지 않는다
		return !memberDao.existsById(username);
	}

	// 아이디 찾기
	public String findId(String email) {
		// return memberDao.findByEmail(email).getUsername(); → 사용자가 없는 경우 NPE(null pointer exception) 발생할 수 있다
		// NPE이 발생하는 지 여부를 판단을 누가 판단할까 → DAO 작성자
		// 메소드를 만드는 사람이 Optional 클래스를 이용해 메소드 사용자에게 NPE여부를 가르쳐주자
		
		// Optional이라는 포장상자안에 Member가 들어있다
		// Optional을 꺼내는 메소드는 get() → null인 경우 NoSuchElememtException 발생
		// memberDao.findByEmail(email).get();	
		Optional<Member> result = memberDao.findByEmail(email);
		if(result.isPresent()==true)
			return result.get().getUsername();
		return "아이디를 찾지 못했습니다";
			
	}
	
	// 회원가입
	public void join(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		System.out.println(member);
		// member.setLevels(Level.BRONZE);
		// memberDao.save(member);
	}
	
	
}


