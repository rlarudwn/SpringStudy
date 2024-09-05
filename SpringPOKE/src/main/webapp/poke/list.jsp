<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="container">
		<div class="row">
			<c:forEach var="vo" items="${list}">
				<div class="col-sm-3">
					<div class="thumbnail">
						<a href="../poke/detail.do?no=${vo.no}"><img src="${vo.poster}"></a>
					</div>
					<p><a href="../poke/detail.do?no=${vo.no}">${vo.name}<small style="color: #aaa;">&nbsp;${vo.form}</small></a>
					</p>
				</div>
			</c:forEach>
		</div>
		<div style="height: 20px;"></div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${startPage>1}">
						<li>
							<a href="../poke/list.do?page=${startPage-1}">&lt;</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<li class="${curPage==i?'active':''}">
							<a href="../poke/list.do?page=${i }">${i}</a>
						</li>
					</c:forEach>
					<c:if test="${endPage<totalPage }">
						<li>
							<a href="../poke/list.do?page=${endPage+1}">&gt;</a>
						</li>
					</c:if>
				</ul>
			</div>
			<form>
			<div class="text-center" style="margin-bottom: 30px;">
			<input type="text" name="ss" size="15" class="input input-sm">
			<button class="btn btn-sm btn-info">검색</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>