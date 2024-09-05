<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0
$(function() {
	$('#addBtn').click(function() {
		let html='<tr id="f'+i+'">'
						+	'<td width="20%">File'+(i+1)+'</td>'
						+ '<td width="80%"><input type="file" name="files['+i+']" size="20"></td>'
						+	'</tr>'
		$('#fileTbody').append(html)
		i++
	})
	$('#removeBtn').click(function() {
		if(i>0){
			$('#f'+(i-1)).remove()
			i--
		}
	})
})
</script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">글쓰기</h3>
		<div class="row">
			<form action="insertOk.do" method="post" enctype="multipart/form-data">
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
						<th class="text-right" width="20%">첨부파일</th>
						<td width="80%">
							<table class="table">
								<tr>
									<td colspan="2" class="text-right">
										<button type="button" class="btn btn-xs btn-success" id="addBtn">Add</button>
										<button type="button" class="btn btn-xs btn-danger" id="removeBtn">Remove</button>
									</td>
								</tr>
							</table>
							<table class="table" id="user-table">
								<tbody id="fileTbody">
								</tbody>
							</table>
						</td>

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
			</form>
		</div>
	</div>

</body>
</html>