<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div class="container-sm mt-5">
		<table class="table">
		<colgruop>
			<col style="width:250px">
			<col>
		</colgruop>
		  <tbody>
		    <tr>
				<th>title</th>
				<td>${boardDto.title}</td>			
		    </tr>
		    <tr>
				<th>writer</th>
				<td>${boardDto.name}</td>			
		    </tr>		    
		    <tr>
				<th>date</th>
				<td>${boardDto.regDate}</td>			
		    </tr>
		    <tr>
				<th>hit</th>
				<td>${boardDto.hit}</td>			
		    </tr>
		    <tr>
				<th>contents</th>
				<td class="contents">${boardDto.contents}</td>			
		    </tr>		    
		  </tbody>
		</table>
	</div>
<%@ include file="../include/footer.jsp"%>