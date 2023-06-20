package com.nou.controller.board;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nou.model.BoardDao;
import com.nou.model.BoardDto;
import com.nou.model.MemberDto;
import com.nou.utils.ScriptWriter;

@WebServlet("/board/writeProcess")
public class WriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WriteProcessController() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		
		BoardDto boardDto=new BoardDto();
		boardDto.setUserId(userId);
		boardDto.setName(userName);
		boardDto.setTitle(title);
		boardDto.setContents(contents);
		
		BoardDao boardDao=new BoardDao();
		
//		for(int i=0; i<100; i++) {
//			boardDto.setName(userName);
//			boardDto.setTitle(title+"_"+i);
//			boardDto.setContents(contents+"_"+i);
//			boardDao.writeBoard(boardDto);			
//		}
		
		int result=boardDao.writeBoard(boardDto);
		if(result>0) {
			response.sendRedirect("../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
		}
	}
}
