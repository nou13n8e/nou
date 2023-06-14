package com.nou.controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.nou.model.MemberDao;
import com.nou.model.MemberDto;

@WebServlet("/member/info")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InfoController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		MemberDao memberDao=new MemberDao();
		MemberDto infoMemberDto=memberDao.getMemberInfo(userId);
		request.setAttribute("infoMemberDto", infoMemberDto);
				
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/member/info.jsp");
		dispatcher.forward(request, response);
	}

}
