<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
		<h3 class="text-center">상세보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-center" width="10%">번호</th>
					<td width="40%">${detail.no }</td>
					<th class="text-center" width="10%">작성일</th>
					<td width="40%">${detail.dbday }</td>
				</tr>
				<tr>
					<th class="text-center" width="10%">이름</th>
					<td width="40%">${detail.name }</td>
					<th class="text-center" width="10%">조회수</th>
					<td width="40%">${detail.hit }</td>
				</tr>
				<tr>
					<th class="text-center" width="20%">제목</th>
					<td colspan="3" width="80%">${detail.subject }</td>
				</tr>
				<tr>
					<c:if test="${detail.filecount!=0 }">
						<tr>
							<th width=20% class="text-center">첨부파일</th>
							<td colspan="3">
								<ul>
									<c:forEach var="fname" items="${nList }" varStatus="s">
										<li><a href="download.do?fn=${fname }">${fname }(${cList[s.index]}Bytes)</a></li>
									</c:forEach>
								</ul>
							</td>
						</tr>
					</c:if>
				</tr>
				<tr>
					<th class="text-center" width="20%">내용</th>
					<td colspan="3" width="80%" height="500px;"><pre style="background: white; border: none; padding: 0px; white-space: pre-wrap;">${detail.content }</pre></td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<button type="button" class="btn btn-sm btn-success" onclick="location.href='update.do?no=${detail.no}'">수정</button>
						<button class="btn btn-sm btn-info" onclick="location.href='delete.do?no=${detail.no}'">삭제</button>
						<button type="button" class="btn btn-sm btn-danger" onclick="location.href='list.do'">목록</button>
					</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>