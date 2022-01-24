package com.icia.servlet3;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.*;

// 두 숫자의 덧셈 : /01_24/test4?val=10&val2=20 -> 서블릿이 결과 30 출력
// 10라인처럼 안만들고 test4_input.jsp, 처리 서블릿, test4_result.jsp로 분리하겠다(View 분리)
@WebServlet("/01_24/test4")
public class Test4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int val1 = NumberUtils.toInt(request.getParameter("val1"));
		int val2 = NumberUtils.toInt(request.getParameter("val2"));
		int result = val1 + val2;
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/01_24/test4_result.jsp");
		rd.forward(request, response);
	}

}
