package com.nou.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.nou.model.BoardDao;
import com.nou.utils.ScriptWriter;

@WebServlet("/board/delete")
public class BoardDeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardDeleteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		BoardDao boardDao=new BoardDao();
		int result=boardDao.deleteBoard(id);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "../board/list");
		}
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
	}

}
