package com.nou.controller.member;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.nou.model.MemberDao;
import com.nou.model.ModifyPasswordDto;
import com.nou.utils.ScriptWriter;

@WebServlet("/member/modifyPasswordProcess")
public class ModifyPasswordProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyPasswordProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		String newUserPw=request.getParameter("newUserPw");

		ModifyPasswordDto modifyPasswordDto=new ModifyPasswordDto();

		modifyPasswordDto.setUserId(userId);
		modifyPasswordDto.setUserPw(userPw);
		modifyPasswordDto.setNewUserPw(newUserPw);
		
		MemberDao memberDao=new MemberDao();
		int result=memberDao.modifyPassword(modifyPasswordDto);
		if(result>0) {
			HttpSession session=request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response, "비밀번호가 변경되었습니다.", "../member/login"); 
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
		}
	}

}
