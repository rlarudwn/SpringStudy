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
	margin-top: 100px;
}

.row {
	width: 1100px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:forEach var="vo" items="${list }">
				<div class="col-sm-3">
					<div class="text-center">
						<div class="thumbnail">
							<a href="detail.do?fno=${vo.fno}"><img src="http://www.menupan.com${vo.poster }" style="width: 200px; height: 200px;"></a>
						</div>
						<a href="detail.do?fno=${vo.fno}"><p>${vo.name }</p></a>
					</div>
				</div>
			</c:forEach>
		</div>
		<div style="height: 10px;"></div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${startPage>1 }">
						<li>
							<a href="list.do?page=${startPage-1}">&lt;</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<li class="${curPage==i?'active':'' }">
							<a href="list.do?page=${i}">${i }</a>
						</li>
					</c:forEach>
					<c:if test="${endPage<totalPage }">
						<li>
							<a href="list.do?page=${endPage+1}">&gt;</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>