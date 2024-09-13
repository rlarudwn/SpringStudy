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
		<form action="../recipe/find.do" method="post">
			<input type="text" size="20" class="input input-sm" name="fd">
			<button class="btn btn-sm btn-success">검색</button>
		</form>
	</div>
	<div style="height: 10px;"></div>
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
						<a href="../recipe/find.do?page=${startPage-1}&fd=${fd}">&lt;</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage }">
					<li class="${curPage==i?'active':'' }">
						<a href="../recipe/find.do?page=${i}&fd=${fd}">${i}</a>
					</li>
				</c:forEach>
				<c:if test="${endPage<totalPage}">
					<li>
						<a href="../recipe/find.do?page=${endPage+1}&fd=${fd}">&gt;</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>