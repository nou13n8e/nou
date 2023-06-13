package com.nou.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nou.model.MemberDao;
import com.nou.utils.ScriptWriter;

@WebServlet("/member/deleteProcess")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");

		MemberDao memberDao=new MemberDao();
		int result=memberDao.deleteMember(userId, userPw);
		if(result>0) {
			HttpSession session=request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response, "회원 탈퇴 되었습니다.", "../member/login"); 
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
		}
	}

}
