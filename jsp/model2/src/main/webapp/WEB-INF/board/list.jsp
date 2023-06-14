<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div class="container-sm mt-5">
		<table class="table">
		<colgruop>
			<col style="width:50px">
			<col>
			<col style="width:150px">
			<col style="width:250px">
			<col style="width:50px">
		</colgruop>
		  <thead>
		    <tr>
		      <th scope="col">no</th>
		      <th scope="col">title</th>
		      <th scope="col">name</th>
		      <th scope="col">date</th>
		      <th scope="col">hit</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${boardList}" var="boardDto">
		    <tr>
		      <td>${boardDto.id}</td>
		      <td><a href="../board/view?id=${boardDto.id}">${boardDto.title}</a></td>
		      <td>${boardDto.name}</td>
		      <td>${boardDto.regDate}</td>
		      <td>${boardDto.hit}</td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
<%@ include file="../include/footer.jsp"%>