<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
	margin-top: 50px;
	width: 1100px !important;
}

.row {
	width: 800px;
	margin: 0px auto !important;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="http://unpkg.com/vue@3"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">글쓰기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td><input type="text" size="15" placeholder="이름" v-model="name" ref="name" class="input input-sm"></td>
				</tr>
				<tr>
					<td><input type="text" size="50" placeholder="제목" v-model="subject" ref="subject" class="input input-sm"></td>
				</tr>
				<tr>
					<td><textarea rows="10" cols="50" placeholder="내용" v-model="content" ref="content" style="resize: none;" class="input input-sm">{{content}}</textarea></td>
				</tr>
				<tr>
					<td><input type="password" size="20" v-model="pwd" ref="pwd" placeholder="비밀번호" class="input input-sm"></td>
				</tr>
				<tr>
					<td class="text-right">
						<button @click="boardUpdate()" type="button" class="btn btn-sm btn-success">글쓰기</button>
						<button type="button" class="btn btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
	let insertApp=Vue.createApp({
		data(){
			return{
				no:${no},
				name:'',
				subject:'',
				content:'',
				pwd:''
			}
		},
		methods:{
			boardUpdate(){
				if(this.name===''){
					this.$refs.name.focus()
					return
				}
				if(this.subject===''){
					this.$refs.subject.focus()
					return
				}
				if(this.content===''){
					this.$refs.content.focus()
					return
				}
				if(this.pwd===''){
					this.$refs.pwd.focus()
					return
				}
				axios.post('../board/vueUpdate.do', null, {
					params:{
						no:this.no,
						name:this.name,
						subject:this.subject,
						content:this.content,
						pwd:this.pwd
					}
				}).then(response=>{
					if(response.data==='OK'){
						location.href='../board/detail.do?no='+this.no
					}
					else{
						alert('비밀번호가 틀렸습니다')
						this.$refs.pwd.value=''
						this.$refs.pwd.focus()
					}
				})
			}
		},
		mounted(){
			axios.get('../board/vueDetailData.do', {
				params:{
					no:this.no
				}
			}).then(response=>{
				console.log(response.data)
				this.name=response.data.name
				this.content=response.data.content
				this.subject=response.data.subject
			})
		}
	}).mount('.container')
	</script>
</body>
</html>