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
		  	<c:forEach items="${boardList}" var="boardDto" varStatus="status">
		    <tr>
		      <td>${pageDto.total - pageDto.pagePerList*(clickPage-1) - status.index}</td>
		      <td>
		      <c:choose>
		      	<c:when test="${boardDto.available eq 1}">
		      		 <a href="../board/view?id=${boardDto.id}&clickPage=${clickPage}" class="step step${boardDto.restep}">${boardDto.title}</a>
		      	</c:when>
		      	<c:otherwise>
		      		 <a href="" class="step step${boardDto.restep} notAvailable">"삭제된 글입니다."</a>
		      	</c:otherwise>
		      </c:choose>
		      </td>
		      <td>${boardDto.name}</td>
		      <td>${boardDto.regDate}</td>
		      <td>${boardDto.hit}</td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		
		<nav aria-label="Page navigation example">
 			 <ul class="pagination justify-content-center">
  				  <li class="page-item">
				      <a class="page-link" href="../board/list?clickPage=1" aria-label="Previous">
				        <span aria-hidden="true">처음으로</span>
				      </a>
				  </li>
 			 	  <c:if test="${pageDto.pageStart ne 1}">
  				  <li class="page-item">
				      <a class="page-link" href="../board/list?clickPage=${pageDto.pageStart-pageDto.pageBlock+(pageDto.pageBlock-1)}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				  </li>
				  </c:if>
				  <c:forEach begin="${pageDto.pageStart}" end="${pageDto.pageEnd}" step="1" var="page" varStatus="status">
					   <li class="page-item ${page==clickPage?'active':''}">
					   <a class="page-link" href="../board/list?clickPage=${page}">${page}</a></li>
				  </c:forEach>
				  <c:if test="${pageDto.pageEnd ne pageDto.pageTotal}">
				  <li class="page-item">
					  <a class="page-link" href="../board/list?clickPage=${pageDto.pageStart+pageDto.pageBlock}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
   				 </li>
   				 </c:if>
  				  <li class="page-item">
				      <a class="page-link" href="../board/list?clickPage=${pageDto.pageTotal}" aria-label="Previous">
				        <span aria-hidden="true">마지막으로</span>
				      </a>
				  </li>
 			 </ul>
		</nav>
		
		<div class="text-center mt-5">
			<a href="../board/write" class="btn btn-primary">WRITE</a>
		</div>
	</div>
<%@ include file="../include/footer.jsp"%>