<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">자유게시판</h3>
		<div class="row">
			<table class="table table-hover">
				<tr>
					<th width="10%" class="text-center">번호</th>
					<th width="45%" class="text-center">제목</th>
					<th width="15%" class="text-center">이름</th>
					<th width="20%" class="text-center">작성일</th>
					<th width="10%" class="text-center">조회수</th>
				</tr>
				<c:forEach var="vo" items="${list}" varStatus="i">
					<tr>
						<td class="text-center">${count-i.index}</td>
						<td><c:if test="${vo.group_tab>0 }">
								<c:forEach begin="1" end="${vo.group_tab}">&nbsp;&nbsp;	</c:forEach>
								<img src="../replyboard/images/re_icon.png">
							</c:if> <c:if test="${vo.subject!=type }">
								<a href="../replyboard/detail.do?no=${vo.no}">${vo.subject }</a>
							</c:if> <c:if test="${vo.subject==type }">
								<span>${vo.subject }</span>
							</c:if> &nbsp; <c:if test="${today==vo.dbday}">
								<sup><img src="../replyboard/images/new.gif"></sup>
							</c:if></td>
						<td class="text-center">${vo.name }</td>
						<td class="text-center">${vo.dbday }</td>
						<td class="text-center">${vo.hit }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" class="text-right"><a href="../replyboard/insert.do" class="btn btn-sm btn-success">글쓰기</a></td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td class="text-center"><a href="../replyboard/list.do?page=${curPage>1?curPage-1:curPage }" class="btn btn-sm btn-info">이전</a> ${curPage }page/${totalPage }page
						<a href="../replyboard/list.do?page=${curPage<totalPage?curPage+1:curPage }" class="btn btn-sm btn-primary">다음</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>