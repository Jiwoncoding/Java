package com.example.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.board.entity.Board;

// 마이바티스에서 인터페이스는 메소드와 SQL을 연결하는 역할
public interface BoardDao {
	// CRUD - create, read, list, update, delete하는 메소드 이름
	// JPA를 사용하면 이름이 표준화되어 있다 - 그 이름을 사용하자
	
	// insert into 테이블이름(컬럼들) values(값들)
	// insert into board(bno,title,content,nickname,password,read_cnt,write_time)
	// values(board_seq.nextval, #{title},#{content},#{nickname},#{password}, #{readCnt},#{writeTime})
	
	// 마이바티스는 기본적으로 null입력이 막혀있다
	// 아래처럼  board_seq.nextval이라고 시퀀스를 사용하면 DAO가 혼자 시퀀스를 사용하고 끝
	// @Insert("insert into board(bno,title,content,nickname,password,read_cnt,write_time) values(board_seq.nextval, #{title},#{content},#{nickname},#{password}, #{readCnt},#{writeTime})")
	// public Integer save(Board board);
	
	// 지금은 글번호(시퀀스)가 컨트롤러에서 필요하다-> /board/read?bno=?로 이동시켜야 하니까
	// 예를 들어 첨부파일을 포함한 글을 저장하는 경우
	//		글을 저장하면 글 번호가 만들어지고 첨부파일은 글번호를 포함해서 저장해야 한다
	// @SelectKey는 @Insert하기 전에 먼저 sql을 실행해 board에 저장한다
	// 	statement를 실행해 결과 int를 board의 bno에 @Insert하기 전에 저장해라
	@SelectKey(statement="select board_seq.nextval from dual", keyProperty="bno", resultType=Integer.class, before=true)
	@Insert("insert into board(bno,title,content,nickname,password,read_cnt,write_time) values(#{bno}, #{title},#{content},#{nickname},#{password}, #{readCnt},#{writeTime})")
	public Integer save(Board board);
	
	@Select("select bno,title,content,nickname,password,read_cnt as readCnt,write_time as writeTime from board where bno=#{bno}")
	public Board findById(Integer bno);
	
	@Select("select bno,title,content,nickname,password,read_cnt as readCnt,write_time as writeTime from board")
	public List<Board> findAll();
	
	
	// update 테이블이름 set 컬럼=값, 컬럼=값 where 조건;
	@Update("update board set title=#{title}, content=#{content} where bno=#{bno} and rownum=1")
	public Integer update(String title, String content, Integer bno);
	
	// 조회수 증가
	@Update("update board set read_cnt=read_cnt+1 where bno=#{bno} and rownum=1")
	public Integer increaseReadCnt(Integer bno);
	
	@Delete("delete from board where bno=#{bno} and rownum=1")
	public Integer deleteById(Integer bno);

}













