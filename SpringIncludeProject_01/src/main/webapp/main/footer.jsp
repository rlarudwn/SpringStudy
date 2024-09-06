<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	text-align: left;
}
</style>
</head>
<body>
	<div class="row text-center">
		<!-- AOP 공통 적용 -->
		<div class="col-sm-4">
			<h3>인기 레시피 Top5</h3>
			<ul style="list-style: none; padding-left: 0px;">
			<c:forEach var="rvo" items="${rtList }" varStatus="r">
			<li class="a"><a href="../recipe/detailBefore.do?no=${rvo.no}">${r.index+1}.${rvo.title }</a></li>
			</c:forEach>
			</ul>
		</div>
		<div class="col-sm-4">
			<h3>인기 맛집 Top5</h3>
			<ul style="list-style: none; padding-left: 0px;">
			<c:forEach var="fvo" items="${ftList }" varStatus="f">
			<li class="a"><a href="../food/detailBefore.do?fno=${fvo.fno}">${f.index+1}.${fvo.name}</a></li>
			</c:forEach>
			</ul>
		</div>
		<div class="col-sm-4">
			<h3>인기 게시물 Top5</h3>
		</div>
	</div>
</body>
</html>