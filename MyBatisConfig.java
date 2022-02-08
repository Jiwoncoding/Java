package com.example.board;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 아래 코드 복붙해서 사용하고 패키지명만 바꿔서 사용하자.
// 자바 클래스 <--> 데이터베이스 : ORM
// 마이바티스는 sql문과 자바 클래스를 분리해서 작성 후 연동하는 프레임워크
// 자바 인터페이스 : 제일 간단한데 sql문이 길어지면 난감해진다..   → 객체를 마이바티스가 생성
// 자바 인터페이스 + xml : 일반적으로 많이 사용하는 형식      → 객체를 마이바티스가 생성, 마이바티스 어노테이션 필요
// 자바 클래스 + xml : 코드가 길어진다                   → @Repository 생성 (객체를 스프링이 생성)

// 데이터베이스와 연동해서 작업하는 클래스를 스프링은 Repository, 보통은 DAO(Data Access Object),
// 마이바티스는 Mapper라고 한다. 마이바티스 인터페이스 방식에서 DAO 객체를 생성할 책임은 마이바티스에 있다.
// 마이바티스에게 매퍼인터페이스의 위치를 알려줘야한다.
@MapperScan("com.example.board.repository")
@Configuration
public class MyBatisConfig {
	// 마이바티스에서 실제 작업을 수행하는 클래스는 SqlSession이다
	// 마이바티스에서 SqlSession을 생성하는 역할을 담당하는 클래스 SqlSessionFactory다.
	// db작업을 할 때는 항상 파라미터로 DataSource가 넘어간다.
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		// 마이바티스에서 xml로 sql을 작성할 떄 전통적으로 클래스 이름을 소문자 별칭을 만들어서 사용한다.
		// com.example.vo.Board → board
		// <select id="getAll" resultType="board">
		// select * from board      절대 ; 찍으면 안된다!!!
		// </select>
		sqlSessionFactory.setTypeAliasesPackage("com.example.board.vo");  // 첫 글자를 소문자로한 별칭을 마이바티스가 만든다. 
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
