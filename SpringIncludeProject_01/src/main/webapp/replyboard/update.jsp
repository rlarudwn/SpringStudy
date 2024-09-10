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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function() {
	$('#updateBtn').click(function() {
		let name=$('#name').val()
		let subject=$('#subject').val()
		let content=$('#content').text		()
		let pwd=$('#pwd').val()
		let no=$('#no').val()
		$.ajax({
			type:'post',
			url:'../replyboard/updateOk.do',
			data:{
				'name':name,
				'content':content,
				'subject':subject,
				'pwd':pwd,
				'no':no
			},
			success:function(result){
				if(result==='NO'){
					alert('비밀번호가 틀립니다')
					$('#pwd').val('')
					$('#pwd').focus()
				}
				else{
					location.href="../replyboard/detail.do?no="+no
				}
			}
		})
	})
})
</script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">글쓰기</h3>
		<div class="row">
				<table class="table">
					<tr>
						<th class="text-right" width="20%">이름</th>
						<td width="80%"><input type="text" id="name" size="20" class="input input-sm" required value="${detail.name }"></td>
					</tr>
					<tr>
						<th class="text-right" width="20%">제목</th>
						<td width="80%"><input type="text" id="subject" size="20" class="input input-sm" required value="${detail.subject }"></td>
					</tr>
					<tr>
						<th class="text-right" width="20%">내용</th>
						<td width="80%"><textarea rows="10" cols="50" id="content" required>${detail.content }</textarea></td>
					</tr>
					<tr>
						<th class="text-right" width="20%">비밀번호</th>
						<td width="80%"><input type="password" id="pwd" size="20" class="input input-sm" required></td>
					</tr>
					<tr>
						<td colspan="2" class="text-right">
							<button type="button" class="btn btn-sm btn-info" id="updateBtn">수정</button>
							<button type="button" class="btn btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</table>
				<input type="hidden" value="${detail.no }" name="no" id="no">
		</div>
	</div>

</body>
</html>