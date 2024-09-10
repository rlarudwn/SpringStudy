<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<h3 class="text-center">답변</h3>
		<div class="row">
			<form action="../replyboard/replyOk.do" method="post">
				<table class="table">
					<tr>
						<th class="text-right" width="20%">이름</th>
						<td width="80%"><input type="text" name="name" size="20" class="input input-sm" required></td>
					</tr>
					<tr>
						<th class="text-right" width="20%">제목</th>
						<td width="80%"><input type="text" name="subject" size="20" class="input input-sm" required></td>
					</tr>
					<tr>
						<th class="text-right" width="20%">내용</th>
						<td width="80%"><textarea rows="10" cols="50" name="content" required></textarea></td>
					</tr>
					<tr>
						<th class="text-right" width="20%">비밀번호</th>
						<td width="80%"><input type="password" name="pwd" size="20" class="input input-sm" required></td>
					</tr>
					<tr>
						<td colspan="2" class="text-right">
							<button class="btn btn-sm btn-info">글쓰기</button>
							<button type="button" class="btn btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="pno" value="${no}">
			</form>
		</div>
	</div>

</body>
</html>