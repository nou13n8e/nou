package com.nou.controller.board;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.nou.model.BoardDao;
import com.nou.model.BoardDto;
import com.nou.utils.ScriptWriter;

@WebServlet("/board/modifyProcess")
public class BoardModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardModifyProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto boardDto=new BoardDto();
		boardDto.setUserId(request.getParameter("userId"));
		boardDto.setId(Integer.parseInt(request.getParameter("id")));
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setName(request.getParameter("userName"));
		boardDto.setContents(request.getParameter("contents"));
		
		BoardDao boardDao=new BoardDao();
		int result=boardDao.modifyBoard(boardDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 수정되었습니다.", "../board/list");
		}
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
	}
}
