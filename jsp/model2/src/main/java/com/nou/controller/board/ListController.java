package com.nou.controller.board;

import java.io.IOException;
import java.util.ArrayList;



import com.nou.model.BoardDao;
import com.nou.model.BoardDto;
import com.nou.model.PageDto;

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
		
		//String strStart=request.getParameter("start");
		//String strEnd=request.getParameter("end");
		
		int clickPage=0;
		String tempClickPage=request.getParameter("clickPage");	//list에 진입했을 때
		if(tempClickPage==null) {								//리스트1에 머물게 하기 위해 설정
			clickPage=1;
		} else {
			clickPage=Integer.parseInt(tempClickPage);
		}
		
		double total=boardDao.getTotal();						//만약 글의 갯수가 108개라면
		double pagePerList=10;									//10개씩 나누어 보여줄 때
		int pageTotal=(int)Math.ceil(total/pagePerList);		//11페이지가 생성되어야 함
		
		int pageBlock=5;
		int pageStart=(clickPage-1)/pageBlock*pageBlock+1;
		int pageEnd=pageStart+pageBlock-1;
		if(pageEnd>pageTotal) {
			pageEnd=pageTotal;
		}
		
		//int start=strStart==null?1:Integer.parseInt(strStart);
		//int end=strEnd==null?(int)pagePerList:Integer.parseInt(strEnd);
		
		int start=(clickPage-1)*(int)pagePerList+1;
		int end=start+(int)pagePerList-1;
		
		PageDto pageDto=new PageDto();
		pageDto.setPageTotal(pageTotal);
		pageDto.setTotal(total);
		pageDto.setPagePerList(pagePerList);
		pageDto.setPageBlock(pageBlock);
		pageDto.setPageStart(pageStart);
		pageDto.setPageEnd(pageEnd);
		
		ArrayList<BoardDto> boardList=boardDao.getList(start, end);	//객체를 담을 수 있는 배열 생성
		request.setAttribute("boardList", boardList);
		request.setAttribute("clickPage", clickPage);
		
		//request.setAttribute("pageTotal", pageTotal);
		//request.setAttribute("total", (int)total);
		//request.setAttribute("pagePerList", (int)pagePerList);
		//request.setAttribute("pageBlock", pageBlock);
		//request.setAttribute("pageStart", pageStart);
		//request.setAttribute("pageEnd", pageEnd);
		
		request.setAttribute("pageDto", pageDto);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}

}
