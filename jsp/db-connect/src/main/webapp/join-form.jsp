<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join-process.jsp" method="post">
		<div>
			<label><span>ID</span><input type="text" name="userId"></label>
		</div>
		<div>
			<label><span>PW</span><input type="password" name="userPw"></label>
		</div>
		<div>
			<label><span>Name</span><input type="text" name="userName"></label>
		</div>
		<div>
			<label><span>Address</span><input type="text" name="address"></label>
		</div>
		<div>
			<label><span>Code</span><input type="text" name="code"></label>
		</div>
		<div>
			<span>Gender</span>
			<label><span>female</span><input type="radio" value="female" name="gender"></label>
			<label><span>male</span><input type="radio" value="male" name="gender"></label>
		</div>
		<div>
			<button>JOIN</button>
		</div>
	</form>
</body>
</html>