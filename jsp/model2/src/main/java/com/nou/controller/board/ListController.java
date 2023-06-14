package com.nou.controller.board;

import java.io.IOException;
import java.util.ArrayList;



import com.nou.model.BoardDao;
import com.nou.model.BoardDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao=new BoardDao();
		ArrayList<BoardDto> boardList=boardDao.getList();	//객체를 담을 수 있는 배열 생성
		request.setAttribute("boardList", boardList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}

}
