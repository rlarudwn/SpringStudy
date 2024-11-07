<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 100px;
}

.row {
	margin: 0px auto;
	width: 350px;
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">로그인</h3>
		<div class="row">
			<form action="../member/loginOk.do" method="post">
				<table class="table">
					<tr>
						<td><input type="text" placeholder="ID" name="id" size="20" class="input input-sm"></td>
					</tr>
					<tr>
						<td><input type="password" placeholder="PASSWORD" name="pwd" size="20" class="input input-sm"></td>
					</tr>
					<tr>
						<td>
							<button class="btn btn-sm btn-info">로그인</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>