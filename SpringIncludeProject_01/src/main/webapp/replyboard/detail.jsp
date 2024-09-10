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
				<th width="20%" class="text-center">번호</th>
				<td width="30%" class="text-center">${detail.no }</td>
				<th width="20%" class="text-center">작성일</th>
				<td width="30%" class="text-center">${detail.dbday }</td>
			</tr>
			<tr>
				<th width="20%" class="text-center">이름</th>
				<td width="30%" class="text-center">${detail.name }</td>
				<th width="20%" class="text-center">조회수</th>
				<td width="30%" class="text-center">${detail.hit }</td>
			</tr>
			<tr>
				<th width="20%" class="text-center">제목</th>
				<td colspan="3">${detail.subject }</td>
			</tr>
			<tr>
				<td colspan="4" class="text-left" valign="top" height="200"><pre style="white-space: pre-wrap; background: white; border: transparent;">${detail.content }</pre></td>
			</tr>
			<tr>
				<td colspan="4" class="text-right">
				<button onclick="location.href='../replyboard/reply.do?no=${detail.no}'" type="button" class="btn btn-sm btn-primary">답변</button>
				<button onclick="location.href='../replyboard/update.do?no=${detail.no}'" type="button" class="btn btn-sm btn-info">수정</button>
				<button onclick="location.href='../replyboard/delete.do?no=${detail.no}'" type="button" class="btn btn-sm btn-danger">삭제</button>
				<button onclick="location.href='../replyboard/list.do'" type="button" class="btn btn-sm btn-success">목록</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>