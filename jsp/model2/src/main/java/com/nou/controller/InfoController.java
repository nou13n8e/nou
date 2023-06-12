package com.nou.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
