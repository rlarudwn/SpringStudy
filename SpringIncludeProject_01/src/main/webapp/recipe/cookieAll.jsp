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
			<c:forEach var="vo" items="${rList }">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="../recipe/detailBefore.do?no=${vo.no}"> <img src="${vo.poster }" title="${vo.title }" style="width: 230px; height: 200px;">
						</a>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${size==0 }">
			<h3>방문한 레시피가 없습니다</h3>
		</c:if>
	</div>
	<div class="row" style="margin-top: 10px;">
	<div class="text-right">
	<a href="../recipe/cookieDelete.do">삭제</a>
	</div>
	 </div>
</body>
</html>