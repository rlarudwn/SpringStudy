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
		<h3 class="text-center">수정하기</h3>
		<div class="row">
			<form @submit.prevent="submitForm">
				<table class="table">
					<tr>
						<td>
							<input type="text" size="30" placeholder="이름" v-model="name" ref="name" class="input input-sm">
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" size="100" placeholder="제목" v-model="subject" ref="subject" class="input input-sm">
						</td>
					</tr>
					<tr>
						<td>
							<input type="file" ref="upfiles" class="input input-sm" v-model="upfiles" multiple="multiple" accept="upload/">
						</td>
					</tr>
					<tr>
						<td>
							<textarea rows="10" cols="100" placeholder="내용" v-model="content" ref="content" style="resize: none;" class="input input-sm"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<input type="password" size="30" v-model="pwd" ref="pwd" placeholder="비밀번호" class="input input-sm">
						</td>
					</tr>
					<tr>
						<td class="text-right">
							<button type="submit" class="btn btn-sm btn-success">수정</button>
							<button type="button" class="btn btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script>
	let updateApp=Vue.createApp({
		data(){
			return{
				name:'',
				subject:'',
				content:'',
				pwd:'',
				upfiles:'',
				no:${no}
			}
		},
		mounted(){
			axios.get('../board/vueDetailData.do', {
				params:{
					no:this.no
				}
			}).then(response=>{
				this.name=response.data.name
				this.subject=response.data.subject
				this.content=response.data.content
			})
		},
		methods:{
			submitForm(){
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
				let formData=new FormData()
				formData.append("name", this.name)
				formData.append("subject", this.subject)
				formData.append("content", this.content)
				formData.append("pwd", this.pwd)
				formData.append("no", this.no)
				let len=this.$refs.upfiles.files.length
				//alert('개수 : '+len)
				if(len>0){
					for(let i=0;i<len;i++){
						formData.append("files["+i+"]", this.$refs.upfiles.files[i])
					}
				}
				axios.post('../board/vueUpdate.do', formData, {
					header:{
						'Context-Type':'multipart/form-data'
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
		}
	}).mount('.container')
	</script>
</body>
</html>
