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
		<div class="row">
			<input type="text" size="30" class="input input-sm" v-model="msg">
		</div>
		<div class="row" id="row">{{msg}}</div>
	</div>
	<script>
	let app=Vue.createApp({
		data(){
			return {
				msg:''
			}
		},
		beforeCreate(){
			console.log('beforeCreate() Call')
		},
		created(){
			console.log('created() Call')
		},
		beforeMount(){
			console.log('beforeMount() Call')
		},
		mounted(){
			console.log('mounted() Call	=> 화면 출력 완료')
		},
		beforeUpdate(){
			console.log('beforeUpdate() Call')
		},
		updated(){
			console.log('updated() Call	=> 데이터에 설정된 변수값 변경')
		},
		beforeDestroy(){
			console.log('beforeDestroy() Call')
		},
		destroyed(){
			console.log('destroyed() Call')
		}
	}).mount('.container')
	//	=> 제어 영역을 지정
	</script>
</body>
</html>