<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.table tr td, .table tr th{
vertical-align: middle !important;
height: 75px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td rowspan="6"><img src="${detail.poster }"></td>
					<th width="15%" class="text-center">도감번호</th>
					<td width="35%">${detail.pno}</td>
					<th width="15%" class="text-center">세대</th>
					<td width="35%">${detail.gen}</td>
				</tr>
				<tr>
					<th class="text-center">이름</th>
					<td colspan="3">${detail.name}&nbsp;<small style="color: #aaa;">${detail.form }</small></td>
				</tr>
				<tr>
					<th width="15%" class="text-center">타입</th>
					<td width="35"><img src="../image/${detail.type1}.png">${detail.type1} <c:if test="${detail.type2!=null}">
							<img src="../image/${detail.type2}.png">${detail.type2}
					</c:if></td>
					<th width="15%" class="text-center">분류</th>
					<td width="35%">${detail.species}</td>
				</tr>
				<tr>
					<th width="15%" class="text-center">무게</th>
					<td width="35%">${detail.weight}</td>
					<th width="15%" class="text-center">키</th>
					<td width="35%">${detail.height}</td>
				</tr>
				<tr>
					<th class="text-center">특성</th>
					<td colspan="3">${detail.ability1}<c:if test="${detail.ability2!=null }">
				${detail.ability2 }
				</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<button type="button" onclick="location.href='../poke/list.do'">목록</button>
					</td>
				</tr>
				<tr>
				<td colspan="5"><pre>${detail.comm }</pre></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>