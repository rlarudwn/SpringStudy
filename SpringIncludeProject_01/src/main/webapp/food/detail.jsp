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
				<td width="30%" class="text-center" rowspan="8"><img src="http://www.menupan.com${detail.poster }" style="width: 200px;" height="300px;"></td>
				<th width="15%" class="text-center">상호명</th>
				<td width="55%">${detail.name }</td>
			</tr>
			<tr>
				<th class="text-center">음식 종류</th>
				<td class="text-center">${detail.type }</td>
			</tr>
			<tr>
				<th class="text-center">테마</th>
				<td class="text-center">${detail.theme}</td>
			</tr>
			<tr>
				<th class="text-center">전화번호</th>
				<td class="text-center">${detail.phone}</td>
			</tr>
			<tr>
				<th class="text-center">주소</th>
				<td class="text-center">${detail.address }</td>
			</tr>
			<tr>
				<th class="text-center">영업시간</th>
				<td class="text-center">${detail.time}</td>
			</tr>
			<tr>
				<td class="text-center" colspan="2">
					<table class="table">
						<tr>
							<th width="16%" class="text-center">좋아요</th>
							<td width="16%" class="text-center">${detail.likecount }</td>
							<th width="16%" class="text-center">찜</th>
							<td width="16%" class="text-center">${detail.jjimcount }</td>
							<th width="16%" class="text-center">조회수</th>
							<td width="16%" class="text-center">${detail.hit}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
			<td colspan="2" class="text-right">
			<button onclick="location.href='../food/list.do'">목록</button>
			</td>
			</tr>
		</table>
		<table class="table">
		<tr>
		<td>
		${detail.content }
		</td>
		</tr>
		</table>
	</div>

</body>
</html>