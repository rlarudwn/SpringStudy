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
	width: 1100px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-center">사번</th>
					<th class="text-center">사원명</th>
					<th class="text-center">직위</th>
					<th class="text-center">급여</th>
					<th class="text-center">입사일</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td class="text-center">${vo.empno }</td>
						<td class="text-center">
							<a href="../emp/empDetail.do?empno=${vo.empno }">${vo.ename }</a>
						</td>
						<td class="text-center">${vo.job }</td>
						<td class="text-center">${vo.sal }</td>
						<td class="text-center">${vo.dbday }</td>
					</tr>
				</c:forEach>
				<tr>
				<td colspan="5">
				<a href="../emp/find.do" class="btn btn-sm btn-success">검색으로 찾기</a>
				</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>