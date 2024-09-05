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
	<div class="row">
		<c:forEach var="vo" items="${list }">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="../food/detailBefore.do?fno=${vo.fno}"> <img src="http://www.menupan.com${vo.poster }" title="${vo.name }" style="width: 230px; height: 200px;">
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
					<li><a href="../food/list.do?page=${startPage-1 }">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<li class="${curPage==i?'active':'' }"><a href="../food/list.do?page=${i}">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage<totalPage}">
					<li><a href="../food/list.do?page=${endPage+1 }">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<h3>방문한 레시피</h3>
	<a href="../food/foodCookieAll.do" class="btn btn-xs btn-primary">더보기</a>
	<div class="row">
		<c:if test="${size>0}">
			<c:forEach var="fvo" items="${fList }" varStatus="i">
				<c:if test="${i.index<6 }">
					<div class="col-sm-2">
						<div class="text-center">
							<div class="thumbnail">
								<a href="../food/detailBefore.do?fno=${fvo.fno}"><img src="http://www.menupan.com${fvo.poster}"></a>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${size==0 }">
			<h3>방문한 맛집 없습니다</h3>
		</c:if>
	</div>
</body>
</html>