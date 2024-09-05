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
					<li><a href="../main/main.do?page=${startPage-1 }">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<li class="${curPage==i?'active':'' }"><a href="../main/main.do?page=${i}">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage<totalPage}">
					<li><a href="../main/main.do?page=${endPage+1 }">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<h3>방문한 레시피</h3>
	<a href="../recipe/cookieAll.do" class="btn btn-xs btn-primary">더보기</a>
	<div class="row">
		<c:if test="${size>0}">
			<c:forEach var="rvo" items="${rList }" varStatus="i">
				<c:if test="${i.index<6 }">
					<div class="col-sm-2">
						<div class="text-center">
							<div class="thumbnail">
								<a href="../recipe/detailBefore.do?no=${rvo.no}"><img src="${rvo.poster}"></a>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${size==0 }">
			<h3>방문한 레시피가 없습니다</h3>
		</c:if>
	</div>
</body>
</html>