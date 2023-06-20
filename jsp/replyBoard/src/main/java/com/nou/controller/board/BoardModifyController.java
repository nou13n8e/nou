package com.nou.controller.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.nou.model.BoardDao;
import com.nou.model.BoardDto;

@WebServlet("/board/modify")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardModifyController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		BoardDao boardDao=new BoardDao();
		BoardDto boardDto=boardDao.getview(id);
		request.setAttribute("boardDto", boardDto);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/board/modify.jsp");
		dispatcher.forward(request, response);
	}

}
