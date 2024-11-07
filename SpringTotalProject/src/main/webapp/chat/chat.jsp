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
	width: 680px;
}

#chatArea {
	height: 500px;
	overflow: auto;
	border: 1px solid black;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script type="text/javascript">
let websocket
let name
function connection() {
	name=$('#name').val()
	if(name.trim()===''){
		alert('이름을 입력하세요')
		$('#name').focus()
		return 
	}
	websocket=new WebSocket("ws://192.168.0.127:8080/web/chat/chat-ws")
	websocket.onOpen=onOpen
	websocket.onclose=onClose
	websocket.onmessage=onMessage
}
function onOpen(event) {
	alert('채팅서버와 연결 완료')
}
function onClose() {
	alert('채팅서버와 연결 해제')
}
function onMessage(event) {
	let data=event.data
	if(data.substr(0,4)==='msg:'){
		appendMessage(data.substr(4))
	}
}
$(function() {
	$('#joinBtn').click(function() {
		connection()
	})
	$('#outBtn').click(function() {
		websocket.close()
	})
	$('#sendBtn').click(function() {
		send()
	})
	$('#sendMsg').keydown(function (key) {
		if(key.keyCode===13){
			send()
		}
	})
})
function appendMessage(msg) {
	$('#recvMsg').append(msg+'<br>')
	let ch=$('#chatArea').height()
	let m=$('#recvMsg').height()-ch
	$('#chatArea').scrollTop(m)
}
function send() {
	let msg=$('#sendMsg').val()
	if(msg.trim()===''){
		alert('메세지를 입력하세요')
		$('#sendMsg').focus()
		return 
	}
	websocket.send('msg:['+name+']'+msg)
	$('#sendMsg').val('')
	$('#sendMsg').focus()
}
</script>
</head>
<body>
	<div class="container">
		<h1 class="text-center">실시간 접속자 채팅</h1>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<input type="text" size="20" id="name" class="input input-sm">
						<button class="btn btn-sm btn-success" id="joinBtn">입장</button>
						<button class="btn btn-sm btn-success" id="outBtn">퇴장</button>
					</td>
				</tr>
				<tr>
					<td>
						<div id="chatArea">
							<div id="recvMsg"></div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" size="60" id="sendMsg" class="input input-sm">
						<button class="btn btn-sm btn-success" id="sendBtn">전송</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>