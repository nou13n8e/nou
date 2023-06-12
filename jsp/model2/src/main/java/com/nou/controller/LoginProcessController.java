package com.nou.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nou.model.MemberDao;
import com.nou.model.MemberDto;
import com.nou.utils.ScriptWriter;

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
		
		HttpSession session = request.getSession();
		if(loggedMember!=null) {
			session.setAttribute("loggedMemberId", loggedMember.getId());
			session.setAttribute("loggedMemberName", loggedMember.getName()); 
			
			session.setAttribute("loggedMember", loggedMember);
			ScriptWriter.alertAndNext(response, loggedMember.getName()+"님, 안녕하세요.", "../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
		}
		System.out.println(loggedMember.toString());
	}
}
