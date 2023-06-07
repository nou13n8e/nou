<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pUserId=request.getParameter("userId");
	String pUserPw=request.getParameter("userPw");
	//2 login-form에서 요청하는 userId, userPw를 대입할 변수 선언

	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="nou";
	String pw="0080";
	//1 sqldeveloper에서 입력한 정보들을 기반으로 작성
	
	Connection conn=null;
	//3 java.sql에 있는 Connection을 연결
	PreparedStatement pstmt=null;
	//4 java.sql에 있는 PreparedStatement(sql에 가서 미리 대기시켜놓는 메서드)를 연결
	ResultSet rs=null;
	//5 java.sql에 있는 ResultSet을 연결
	
	String sql="select * from member where id = ? and password = ?";
	//8 연결된 db에서 받아올 정보의 조건을 설정(외부에서 받아올 정보이기 떄문에 ? 처리) = 쿼리?
	
	Class.forName(driver);
	//6 driver의 클래스를 찾도록 설정
	conn=DriverManager.getConnection(url, id, pw);
	//7 java.sql에 있는 DriverManamger를 연결한 뒤 url, id, pw의 값을 받도록 설정
	pstmt=conn.prepareStatement(sql);
	//9 sql에 가서 미리 대기시켜놓는 메서드
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserPw);
	//10 연결된 db에서 받아올 정보의 순서와 값을 getString으로 처리
	rs=pstmt.executeQuery();
	//11 return되는 값을 rs에 대입 = 쿼리의 실행?
	
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	//13 한글을 정상적으로 입,출력하기 위해 기입
	//14 서버는 "로그인 성공"을 띄우고 나면 stateless 성질에 의해 클라이언트와의 관계를 끊음
	//15 tomcat 서버에는 pageContext < request < session < applicationContext 유효범위의 순서가 있음
	
	if(rs.next()){
		String userId=rs.getString("id");
		String userPw=rs.getString("password");
		String userName=rs.getString("name");
		//out.println("로그인 성공");
		
		//response.sendRedirect("login-ok.jsp?userId="+userId);
		//16 로그인에 성공하면 특정 페이지가 바뀌게끔 설정(userId 전달 불가능)
		//페이지가 바뀔 때 userId의 값을 받을 수 있게 직접 입력하는 방법
		
		//pageContext.setAttribute("pageUserId", userId);
		//18 pageContext는 해당 페이지를 벗어나면 작동하지 않음
		session.setAttribute("loggedUserId", userId);
		session.setAttribute("loggedUserName", userName);
		//19 session은 끊기 전까지 작동함
		
		//request.setAttribute("loggedUserId", userId);
		request.getRequestDispatcher("login-ok.jsp").forward(request, response);
		//17 로그인에 성공하면 특정 페이지가 바뀌게끔 설정(userId 전달 가능)
		
	} else {
		out.println("로그인 실패");
	}
	//12 rs에 기입되는 값이 있다면 true 실행문 실행
	
%>