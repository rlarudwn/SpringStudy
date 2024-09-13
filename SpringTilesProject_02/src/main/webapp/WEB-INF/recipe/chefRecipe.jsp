<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<c:forEach var="vo" items="${list}">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="../recipe/detail.do?no=${vo.no}"> <img src="${vo.poster }" title="${vo.title }" style="margin: 0px; width: 245px;">
						<div class="caption">
							<p>${vo.chef }</p>
						</div>
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
					<li>
						<a href="../recipe/chefRecipe.do?page=${startPage-1}&chef=${chef}">&lt;</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage }">
					<li class="${curPage==i?'active':'' }">
						<a href="../recipe/chefRecipe.do?page=${i}&chef=${chef}">${i}</a>
					</li>
				</c:forEach>
				<c:if test="${endPage<totalPage}">
					<li>
						<a href="../recipe/chefRecipe.do?page=${endPage+1}&chef=${chef}">&gt;</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>