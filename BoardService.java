package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.entity.Board;

// @Component는 스프링이 객체를 생성해 ApplicationContext에 등록
// @Component의 스페셜 버전 : @Controller, @Service, @Repository
// BoardDao는 sql이 지정된 인터페이스고 마이바티스가 객체를 생성해 ApplicationContext에 등록한다
//		그 설정이 MyBatisConfig에 있는 @MapperScan. 따라서 @Repository를 사용해서는 안된다
@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	// 글쓰기(P), 글목록, 글읽기(조회수 증가), 글변경(P), 글삭제(P)
	public Boolean write(Board board) {
		// 항상 일정한 결과가 나오면 암호화가 아니다. 랜덤이라는 양념이 필요(OTP, captcha 등)
		String encodedPassword = BCrypt.hashpw(board.getPassword(), BCrypt.gensalt(10));
		board.setPassword(encodedPassword);
		return dao.save(board)!=0;
	}
	
	// 하는 일이 없잖아?? 화면 <- 컨트롤러 <- 서비스 < - DAO.
	// 컨트롤러는 서비스만 바라본다(DAO의 존재는 모른다)
	public List<Board> list() {
		List<Board> list = dao.findAll();
		for(Board board:list) 
			board.setPassword(null);
		return list;
	}
	
	public Board read(Integer bno) {
		dao.increaseReadCnt(bno);
		return dao.findById(bno).setPassword(null);
	}
	
	public Boolean update(String title, String content, String password, Integer bno) {
		// 비밀번호가 맞는 지 확인 -> bno로 Board를 읽어와야 한다
		Board board = dao.findById(bno);
		// 글을 찾을 수 없다면
		if(board==null)
			return false;
		// 비밀번호 확인에 실패했다면
		if(BCrypt.checkpw(password, board.getPassword())==false)
			return false;
		return dao.update(title, content, bno)!=0;
	}
	
	public Boolean delete(String password, Integer bno) {
		Board board = dao.findById(bno);
		if(board==null)
			return false;
		if(BCrypt.checkpw(password, board.getPassword())==false)
			return false;
		return dao.deleteById(bno)!=0;
	}
	
}








