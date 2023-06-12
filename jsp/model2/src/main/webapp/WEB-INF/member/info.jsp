<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-sm mt-5">
  <table class="table">
    <tbody>
      <tr>
        <th scope="row">ID</th>
        <td><c:out value="${requestScope.infoMemberDto.id}" /></td>
      </tr>
      <tr>
        <th scope="row">Name</th>
        <td><c:out value="${requestScope.infoMemberDto.name}" /></td>
      </tr>
        <tr>
        <th scope="row">E-mail</th>
        <td><c:out value="${requestScope.infoMemberDto.email}" /></td>
      </tr>
      <tr>
        <th scope="row">Address</th>
        <td><c:out value="${requestScope.infoMemberDto.address} ${requestScope.infoMemberDto.detailAddress} ${requestScope.infoMemberDto.extraAddress}" /></td>
      </tr>
      <tr>
        <th scope="row">Code</th>
        <td><c:out value="${requestScope.infoMemberDto.zonecode}" /></td>
      </tr>
    </tbody>
  </table>
  <div class="mt-5">
    <a href="modify.jsp" class="btn btn-primary">회원 정보 수정</a>
    <a href="modify-password.jsp" class="btn btn-primary">비밀번호 변경</a>
    <a href="delete.jsp" class="btn btn-danger">회원 탈퇴</a>
  </div>
</div>
<%@ include file="../include/footer.jsp" %>
