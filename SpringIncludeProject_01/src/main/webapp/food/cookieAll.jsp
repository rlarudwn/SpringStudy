<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

.a {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="row">
		<c:if test="${size>0 }">
			<c:forEach var="vo" items="${fList }">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="../food/detailBefore.do?fno=${vo.fno}"> <img src="http://www.menupan.com${vo.poster }" title="${vo.name }" style="width: 230px; height: 200px;">
						</a>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${size==0 }">
			<h3>방문한 맛집이 없습니다</h3>
		</c:if>
	</div>
	<div class="row" style="margin-top: 10px;">
	<div class="text-right">
	<a href="../food/foodCookieDelete.do">삭제</a>
	</div>
	 </div>
</body>
</html>