<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
	width: 1100px;
}

.row {
	margin: 0px auto;
}

.nav-link {
	cursor: pointer;
}

p {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<h1>로그인</h1>
		<div class="row">
			<table class="table">
				<tr>
					<td><input type="text" placeholder="ID" ref="id" v-model="id" class="input input-sm" size="20"></td>
				</tr>
				<tr>
					<td><input type="password" placeholder="PWD" ref="pwd" v-model="pwd" class="input input-sm" size="20"></td>
				</tr>
				<tr>
					<td><button type="button" class="btn btn-sm btn-info" @click="login()">로그인</button></td>
				</tr>
			</table>
		</div>
	</div>
	<script>
	let loginApp=Vue.createApp({
		data(){
			return{
				id:'',
				pwd:'',
				msg:''
			}
		},
		methods:{
			login(){
				if(this.id===''){
					alert('아이디를 입력하세요')
					this.$refs.id.focus()
					return
				}
				if(this.pwd===''){
					alert('비밀번호를 입력하세요')
					this.$refs.pwd.focus()
					return
				}
				axios.post('../food/vueLogin.do', null, {
					params:{
						id:this.id,
						pwd:this.pwd
					}
				}).then(response=>{
					console.log(response.data)
					if(response.data==='NOID'){
						alert('아이디가 존재하지 않습니다')
						this.$refs.id.focus()
						this.id=''
					}
					else if(response.data==='NOPWD'){
						alert('비밀번호가 틀립니다')
						this.$refs.pwd.focus()
						this.pwd=''
					}
					else{
						location.href='../recipe/list.do'
					}
				})
			}
		},
		mounted(){
			
		}
	}).mount('.container')
	</script>
</body>
</html>