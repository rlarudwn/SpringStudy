<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 960px;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<c:forEach var="vo" items="${list}">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="#"></a>
						<img src="http://www.menupan.com${vo.poster }" style="width: 230px; height: 150px;">
						<div class="caption">${vo.name }</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div style="height: 20px;"></div>
	<div class="row">
		<div class="text-center"></div>
	</div>
</body>
</html>