<%@page import="com.nou.utils.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");

   String pLoggedUserId=(String)session.getAttribute("loggedUserId");
   //로그인 된 아이디의 값은 session에 담겨있으므로 getAttribute로 값을 가져올 것
   String pUserPw=request.getParameter("userPw");
   String pNewUserPw=request.getParameter("newUserPw");
   //newUserPw의 값은 modify-password.jsp에서 넘어오므로 request로 값을 가져올 것
      
   String driver = "oracle.jdbc.OracleDriver";
   String url="jdbc:oracle:thin:@localhost:1521:xe";
   String id="nou";
   String pw = "0080";
   
   Connection conn = null;
   PreparedStatement pstmt = null;
   //ResultSet rs =null;
   //select일 때만 사용하는 것
   
   String sql = "update member set password = ? where id = ? and password = ?";
   
   Class.forName(driver);
   conn = DriverManager.getConnection(url,id,pw);
   pstmt=conn.prepareStatement(sql);
   pstmt.setString(1, pNewUserPw);
   pstmt.setString(2, pLoggedUserId);
   pstmt.setString(3, pUserPw);

   int result = pstmt.executeUpdate();
   if(result > 0){
	  out.println("<script>alert('비밀번호가 변경되었습니다.'); location.href='login-form.jsp';</script>");
	  //alert를 띄우고 넘어갈 거라면 location.href를 사용할 것
	  //ScriptWriter.alertAndNext(response, "비밀번호가 변경되었습니다.", "login-form.jsp");
	  
      session.invalidate();
      //세션을 끊어줄 것
   }else{
      out.println("<script>alert('비밀번호 변경 실패(서버 오류)'); history.back();</script>");
      //ScriptWriter.alertAndBack(response, "비밀번호 변경 실패(서버 오류)");
   }
   
%>