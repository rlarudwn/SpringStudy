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
	width: 1100px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<input type="text" size="20" class="input input-sm" ref="fd" v-model="fd">
			<button type="button" class="btn btn-sm btn-primary" @click="find()">검색</button>
		</div>
	</div>
	<script>
	let app=Vue.createApp({
		data(){
			return{
				fd:''
			}
		},
		methods:{
			find(){
				let fds=this.$refs.fd.value
				if(fds===''){
					alert('검색어를 입력하세요')
					this.$refs.fd.focus()
					return
				}
				alert('검색어 : '+this.fd)
			}
		}
	}).mount('.container')
	</script>
</body>
</html>