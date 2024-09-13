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
		<table class="table">
			<tr>
				<td class="text-center" colspan="3"><img src="${detail.poster}" style="width: 800px; height: 500px;"></td>
			</tr>
			<tr>
				<td class="text-center" colspan="3">
					<h3>${detail.title }</h3>
				</td>
			</tr>
			<tr>
				<td colspan="3">${detail.content }</td>
			</tr>
			<tr>
				<td class="text-center"><img src="../images/a1.png"></td>
				<td class="text-center"><img src="../images/a2.png"></td>
				<td class="text-center"><img src="../images/a3.png"></td>
			</tr>
			<tr>
				<td class="text-center">${detail.info1}</td>
				<td class="text-center">${detail.info2}</td>
				<td class="text-center">${detail.info3}</td>
			</tr>
		</table>
		<h3>재료</h3>
		<table class="table">
			<tr>
				<td>
					<ul>
						<c:forTokens items="${detail.data}" delims="," var="i">
							<li>${i}</li>
						</c:forTokens>
					</ul>
				</td>
			</tr>
		</table>
		<h3>조리순서</h3>
		<table class="table">
			<c:forEach var="s" items="${mList }" varStatus="i">
				<tr>
					<td width="70%" class="text-left">${s}</td>
					<td width="30%" class="text-right" style="padding: 5px;"><img src="${iList[i.index]}" style="width: 300px; height: 170px;"
							class="img-rounded"></td>
				</tr>
			</c:forEach>
		</table>
		<h3>[레시피 작성자]</h3>
		<table class="table">
			<tr>
				<td class="text-center" rowspan="2" width="15%"><img src="${detail.chef_poster }" style="width: 100px;height: 100px;" class="img-circle"></td>
				<td width="85%"><h4>${detail.chef }</h4></td>
			</tr>
			<tr>
				<td width="85%"><h4>${detail.chef_profile }</h4></td>
			</tr>
		</table>
		<table class="table">
		<tr>
		<td class="text-right">
		<button type="button" class="btn btn-sm btn-success">좋아요</button>
		<button type="button" class="btn btn-sm btn-info">찜하기</button>
		<button type="button" class="btn btn-sm btn-primary" onclick="javascript:history.back()">목록</button>
		</td>
		</tr>
		</table>
	</div>
</body>
</html>