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
		
		String strStart=request.getParameter("start");
		String strEnd=request.getParameter("end");
		
		double pagePerList=10;									//10개씩 나누어 보여줄 때
		double total=boardDao.getTotal();						//만약 글의 갯수가 108개라면
		int pageTotal=(int)Math.ceil(total/pagePerList);		//11페이지가 생성되어야 함
	
		int start=strStart==null?1:Integer.parseInt(strStart);
		int end=strEnd==null?(int)pagePerList:Integer.parseInt(strEnd);
		
		ArrayList<BoardDto> boardList=boardDao.getList(start, end);	//객체를 담을 수 있는 배열 생성
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageTotal", pageTotal);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}

}
