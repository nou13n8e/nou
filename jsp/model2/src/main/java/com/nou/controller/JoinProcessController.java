package com.nou.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nou.model.MemberDao;
import com.nou.model.MemberDto;
import com.nou.utils.ScriptWriter;

@WebServlet("/member/joinProcess")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		String userName=request.getParameter("userName");
		int userZonecode=Integer.parseInt(request.getParameter("zonecode"));
		String userAddress=request.getParameter("userAddress");
		String userDetailAddress=request.getParameter("detailAddress");
		String userExtraAddress=request.getParameter("extraAddress");
		String userEmail=request.getParameter("userEmail");
		
		MemberDao memberDao=new MemberDao();
		MemberDto memberDto=new MemberDto();
		
		memberDto.setId(userId);
		memberDto.setName(userName);
		memberDto.setEmail(userEmail);
		memberDto.setPassword(userPw);
		memberDto.setZonecode(userZonecode);
		memberDto.setAddress(userAddress);
		memberDto.setDetailAddress(userDetailAddress);
		memberDto.setExtraAddress(userExtraAddress);
		
		int result=memberDao.insertMember(memberDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../member/login"); 
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
		}
	}

}
