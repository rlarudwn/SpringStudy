<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width: 1100px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="../emp/findOk.do" method="post">
				<table class="table">
					<tr>
						<c:forEach var="s" items="${list}">
							<td>
								<label><input type="checkbox" name="names" value="${s}">${s}</label>
							</td>
						</c:forEach>
					</tr>
					<tr>
						<td colspan="${size }">
							<button class="btn btn-sm btn-primary">검색</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>