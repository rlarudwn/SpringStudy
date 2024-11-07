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
	width: 500px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<div class="container">
		<div class="row" id="app1">
			<div class="text-center">{{msg}}</div>
		</div>
		<div class="row" id="app2">
			<div class="text-center">{{msg}}</div>
		</div>
	</div>
	<script>
	let app1=Vue.createApp({
		data(){
			return{
				msg:'hello vue3'
			}
		}
	}).mount('#app1')
	</script>
</body>
</html>