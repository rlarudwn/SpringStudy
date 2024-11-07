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
</head>
<body>
	<div class="container" id="app1">
		<div class="row">
			<button @click="login(true)" type="button" class="btn btn-sm btn-danger">login</button>
			<button @click="login(false)" type="button" class="btn btn-sm btn-warning">logout</button>
			<div v-if="check===true">로그인</div>
			<div v-if="check===false">로그아웃</div>
		</div>
		<div class="container" id="app2">
			<div class="row">
				<button @click="select(1)" type="button" class="btn btn-sm btn-primary">한식</button>
				<button @click="select(2)" type="button" class="btn btn-sm btn-warning">중식</button>
				<button @click="select(3)" type="button" class="btn btn-sm btn-default">일식</button>
				<button @click="select(4)" type="button" class="btn btn-sm btn-info">양식</button>
				<button @click="select(5)" type="button" class="btn btn-sm btn-danger">분식</button>
			</div>
			<div style="height: 10px;"></div>
			<div class="row">
				<div v-if="type===1">한식을 선택했습니다</div>
				<div v-else-if="type===2">중식을 선택했습니다</div>
				<div v-else-if="type===3">일식을 선택했습니다</div>
				<div v-else-if="type===4">양식을 선택했습니다</div>
				<div v-else-if="type===5">분식을 선택했습니다</div>
			</div>
		</div>
	</div>
	<script>
		let app1=Vue.createApp({
			data(){
				return{
					check:false
				}
			},
			methods:{
				login(bCheck){
					this.check=bCheck
				}
			}
		}).mount('#app1')
		
		let app2=Vue.createApp({
			data(){
				return{
					type:1
				}
			},
			methods:{
				select(value){
					this.type=value
				}
			}
		}).mount('#app2')
		</script>
</body>
</html>