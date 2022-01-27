package com.icia.zboard2.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/zboard2/example")
public class ZBoard2SessionExampleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// zboar1에서 문제가 벌어지면 무조건 /zboard/list로 보내버렸다
		// 문제가 발생하면 sendRedirect했다 -> 이동 후 적절한 메시지를 출력해보자
		// 		/zboard/delete에서 삭제 실패 -> /zboard/list로 이동 후 list.jsp에서 오류 메시지 출력
		//		즉 서블릿에서 jsp로 오류 메시지를 보내줘야한다
		//			/zboard/delete 오류 발생 -> /zboard/list로 이동 -> list.jsp로 포워드 후 오류 메시지
		
		// request는 서블릿을 벗어날 수 없다
		// 서블릿이 하나의 작업. request는 작업의 시작, 작업이 끝나면 새로운 작업을 시작해야 하고 request는 파괴 된다
		// 즉 /zboard/delete에서 에러 메시지를 request에 담아 /zboard/list로 이동시켜도 request가 파괴되기 때문에
		//		메시지도 사라진다 -> HttpSession을 사용해야 한다
		HttpSession session = request.getSession();
		session.setAttribute("msg", "글을 찾을 수 없습니다");
		RequestDispatcher rd = request.getRequestDispatcher("/zboard2/example.jsp");
		rd.forward(request, response);
	}

}
