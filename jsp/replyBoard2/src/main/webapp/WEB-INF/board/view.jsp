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
		<div class="text-center mt-5">
				<a href="../board/write" class="btn btn-secondary">WRITE</a>
				<a href="../board/reply?regroup=${boardDto.regroup}&relevel=${boardDto.relevel}&restep=${boardDto.restep}" class="btn btn-warning">REPLY</a>
			<c:if test="${loggedMember.id eq boardDto.userId}">
				<a href="../board/modify?id=${boardDto.id}" class="btn btn-primary">MODIFY</a>
				<a href="../board/delete?id=${boardDto.id}" id="btnDelete" class="btn btn-danger">DELETE</a>
			</c:if>
				<a href="../board/list?clickPage=${param.clickPage}" class="btn btn-secondary">LIST</a>
		</div>
		<script>
			const btnDelete=document.querySelector("#btnDelete");
			btnDelete.addEventListener("click",(e)=>{
				e.preventDefault();
				const isDelete=confirm("삭제하시겠습니까?");
				if(isDelete){
					location.href="../board/delete?id="+${boardDto.id};
				}
			});
		</script>
	</div>
<%@ include file="../include/footer.jsp"%>