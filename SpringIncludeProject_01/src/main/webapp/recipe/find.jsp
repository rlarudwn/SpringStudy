<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.a {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<h3>
		총
		<fmt:formatNumber value="${count }" pattern="###,###,###" />
		개의 맛있는 레시피가 있습니다
	</h3>
	<div class="row">
		<form action="">
			<input type="text" size="20" name="fd" class="input input-sm">
			<button class="btn btn-sm btn-primary">검색</button>
		</form>
	</div>
	<div class="row">
		<c:forEach var="vo" items="${list }">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="../recipe/detailBefore.do?no=${vo.no}"> <img src="${vo.poster }" title="${vo.title }" style="width: 230px; height: 200px;">
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div style="height: 10px;"></div>
	<div class="row">
		<div class="text-center">
			<ul class="pagination">
				<c:if test="${startPage>1}">
					<li><a href="../recipe/find.do?page=${startPage-1 }&fd=${fd}">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<li class="${curPage==i?'active':'' }"><a href="../recipe/find.do?page=${i}&fd=${fd}">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage<totalPage}">
					<li><a href="../recipe/find.do?page=${endPage+1 }&fd=${fd}">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<jsp:include page="../recipe/recipeCookie.jsp"/>
</body>
</html>