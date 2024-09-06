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
				<td width="30%" class="text-center" rowspan="5"><img src="${detail.goods_poster }" style="width: 200px;" height="300px;"></td>
				<th width="15%" class="text-center">제품명</th>
				<td width="55%">${detail.goods_name }</td>
			</tr>
			<tr>
				<th class="text-center">제품 설명</th>
				<td class="text-center">${detail.goods_sub}</td>
			</tr>
			<tr>
				<th class="text-center">가격</th>
				<td class="text-center">${detail.goods_price}</td>
			</tr>
			<tr>
				<th class="text-center">배달비</th>
				<td class="text-center">${detail.goods_delivery}</td>
			</tr>
			<tr>
			<td colspan="2" class="text-right">
			<button onclick="location.href='../goods/list.do'">목록</button>
			</td>
			</tr>
		</table>
	</div>

</body>
</html>