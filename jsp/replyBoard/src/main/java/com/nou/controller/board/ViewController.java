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

@WebServlet("/board/view")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		BoardDao boardDao=new BoardDao();
		BoardDto boardDto=boardDao.getview(id);
		request.setAttribute("boardDto", boardDto);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/board/view.jsp");
		dispatcher.forward(request, response);
	}

}
