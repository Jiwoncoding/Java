package com.icia.servlet4;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// doGet은 페이지를 보여주고, doPost는 처리 후 결과를 보여준다
// 처리기능이 없는 서블릿은 doGet만 가진다
// 처리가능만 가지는 서블릿은 doPost만 가진다(로그아웃)

@WebServlet("/servlet4/index")
public class RootServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/servlet4/index.jsp");
		rd.forward(request, response);
	}
}
