<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	height: 300px;
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">삭제</h3>
		<div class="row">
			<form action="deleteOk.do" method="post" class="text-center">
				비밀번호 입력 : <input type="password" name="pwd" size="20" class="input input-sm"> <input type="hidden" name="no" value="${no}">
				<button class="btn btn-sm btn-danger">확인</button>
				<button class="btn btn-sm btn-primary" type="button" onclick="javascript:history.back()">취소</button>
			</form>
		</div>
	</div>
</body>
</html>