<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<table class="table">
			<tr>
				<th width="30%" class="text-center">사번</th>
				<td width="70%" class="text-center">${detail.empno }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">사원명</th>
				<td width="70%" class="text-center">${detail.ename }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">직위</th>
				<td width="70%" class="text-center">${detail.job }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">입사일</th>
				<td width="70%" class="text-center">${detail.dbday }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">급여</th>
				<td width="70%" class="text-center">${detail.sal }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">부서명</th>
				<td width="70%" class="text-center">${detail.dvo.dname }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">근무지</th>
				<td width="70%" class="text-center">${detail.dvo.loc }</td>
			</tr>
			<tr>
				<th width="30%" class="text-center">호봉</th>
				<td width="70%" class="text-center">${detail.svo.grade }</td>
			</tr>
			<tr>
			<td colspan="2" class="text-right">
			<button type="button" onclick="location.href='../emp/list.do'" class="btn btn-sm btn-info">목록</button>
			</td>
			</tr>
		</table>
	</div>
</body>
</html>