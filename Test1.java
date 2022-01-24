package com.icia.servlet3;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.commons.lang3.math.*;

// 자바 프로그램 <-> url:외부에서 자바 프로그램을 부르는 이름
// url을 통해 백엔드 프로그램에 대한 추측이 가능하도록 만들지 않는다
@WebServlet("/01_24/test1")
public class Test1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value = NumberUtils.toInt(request.getParameter("value"));
		
		// 여기서 System.out은 사용자 컴퓨터가 아니라 서버 컴퓨터 -> 프로그래머만 확인
		System.out.println(value);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>입력 결과</title>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
		out.println("<script>");
		out.println("$(document).ready(function() {");
		out.println("alert('hello');");
		out.println("})");
		out.println("</script></head>");
		out.println("<body>");
		out.println("<p>입력한 숫자 : " + value + "<p>");
		out.println("</body>");
		
		// 속도 향상을 위해서 서버는 출력을 모아서 한다 -> 내 꺼는 출력하세요
		out.flush();
		
	}
}




