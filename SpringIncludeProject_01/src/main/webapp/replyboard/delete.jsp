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
	height: 300px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#delBtn').click(function() {
			let pwd = $('#pwd').val()
			let no = $('#no').val()
			$.ajax({
				type : 'post',
				url : '../replyboard/deleteOk.do',
				data : {
					'no' : no,
					'pwd' : pwd
				},
				success : function(result) {
					if (result === 'OK') {
						location.href = '../replyboard/list.do'
					} else {
						alert('비밀번호가 틀립니다')
						$('#pwd').val('')
						$('#pwd').focus()
					}
				}
			})
		})
	})
</script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">삭제</h3>
		<div class="row">
			비밀번호 입력 : <input type="password" id="pwd" size="20" class="input input-sm"> <input type="hidden" id="no" name="no" value="${no}">
			<button type="button" class="btn btn-sm btn-danger" id="delBtn">삭제</button>
			<button class="btn btn-sm btn-primary" type="button" onclick="javascript:history.back()">취소</button>
		</div>
	</div>
</body>
</html>