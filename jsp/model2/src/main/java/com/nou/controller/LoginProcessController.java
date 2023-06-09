package com.nou.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nou.model.MemberDao;
import com.nou.model.MemberDto;

@WebServlet("/member/loginProcess")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginProcessController() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		MemberDao memberDao=new MemberDao();
		MemberDto memberDto=new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		MemberDto loggedMember=memberDao.loginMember(memberDto);
		System.out.println(loggedMember.toString());
	}
}
