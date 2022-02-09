package com.example.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.dao.BoardDao;
import com.example.board.entity.Board;

// 스프링 설정 파일 읽어와서 ApplicationContext가 구성해라
@SpringBootTest
public class BoardDaoTest {
	@Autowired
	private BoardDao dao;
	
	// 첫번째 테스트는 스프링이 정상 실행되어 DI가 동작하는 지 확인
	// 실패했어-> 제일 위에 starting ApplicationContext 메시지가 있는 경우 
	//				-> ApplicationContext를 못만들어서 주입에 실패(설정에 큰 오류가 있다)
	//		    아니라면 -> ApplicationContext는 생성되었다(내가 원하는 거와는 다르게)
	//				-> 설정에 단순 오타 또는 어노테이션을 사용하지 않았다
	// @Test
	public void initTest() {
		assertNotNull(dao);
	}
	
	//@Test
	public void findAllTest() {
		assertEquals(0, dao.findAll().size());
	}
	
	//@Test
	public void findByIdTest() {
		assertNull(dao.findById(120));
	}

	//@Test
	public void insertWithSelectKey() {
		Board board = new Board("예제", "예제글", "summer", "1234");
		// selectKey를 사용해 dao에 전달된 board에 bno을 저장 
		dao.save(board);
		Board result = dao.findById(board.getBno());
		System.out.println(result);
	}
	
	//@Test
	public void updateTest() {
		int result = dao.update("변경했어요", "변경했다니까", 1);
		assertEquals(1, result);
	}
	
	//@Test
	public void increaseReadCntTest() {
		dao.increaseReadCnt(1);
		Board result = dao.findById(1);
		System.out.println(result);
	}
	
	// 테스트할 때 @Transactional을 붙이면 자동으로 rollback
	@Transactional
	@Test
	public void deleteByIdTest() {
		dao.deleteById(1);
	}
	
}
