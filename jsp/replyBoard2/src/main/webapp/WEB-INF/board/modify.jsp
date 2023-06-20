<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div class="container-sm mt-5">
		<form action="../board/modifyProcess" method="post">
		<input type="hidden" name="userId" value="${loggedMember.id}">
		<input type="hidden" name="id" value="${boardDto.id}">
			<div class="mb-3">
			  <label for="title" class="form-label">제목</label>
			  <input type="text" class="form-control" name="title" id="title" value="${boardDto.title}" placeholder="제목을 입력해주세요.">
			</div>
			<div class="mb-3">
			  <label for="userName" class="form-label">이름</label>
			  <input type="text" class="form-control" name="userName" id="userName" value="${boardDto.name}" placeholder="이름을 입력해주세요.">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">내용</label>
			  <textarea class="form-control" name="contents" id="contents" rows="10">${boardDto.contents}</textarea>
			</div>
			<div class="text-center mt-5">
			  <button type="reset" class="btn btn-secondary btn" id="btnCancel">CANCEL</button>
       	  	  <button type="submit" class="btn btn-primary btn" id="btnSubmit">MODIFY</button>
     	    </div>
		</form>
	<script>
      $("#contents").summernote({
        tabsize: 2,
        height: 100
      });
    </script>
	</div>
<%@ include file="../include/footer.jsp"%>