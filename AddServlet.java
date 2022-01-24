package com.icia.servlet4;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.*;


@WebServlet("/servlet4/add")
public class AddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/servlet4/add.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value1 = NumberUtils.toInt(request.getParameter("value1"));
		int value2 = NumberUtils.toInt(request.getParameter("value2"));
		int result = value1 + value2;
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/servlet4/result.jsp");
		rd.forward(request, response);
	}
}








