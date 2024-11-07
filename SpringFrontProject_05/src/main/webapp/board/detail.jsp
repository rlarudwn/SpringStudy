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
	width: 1100px !important;
}

.row {
	width: 800px;
	margin: 0px auto !important;
}
</style>
<script src="http://unpkg.com/vue@3"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">내용보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width="15%" class="text-center">번호</th>
					<td width="35%" class="text-center">{{vo.no}}</td>
					<th width="15%" class="text-center">작성일</th>
					<td width="35%" class="text-center">{{vo.dbday}}</td>
				</tr>
				<tr>
					<th width="15%" class="text-center">이름</th>
					<td width="35%" class="text-center">{{vo.name}}</td>
					<th width="15%" class="text-center">조회수</th>
					<td width="35%" class="text-center">{{vo.hit}}</td>
				</tr>
				<tr>
					<th width="15%" class="text-center">제목</th>
					<td colspan="3">{{vo.subject}}</td>
				</tr>
				<tr v-show="vo.filecount!==0">
					<th width="15%" class="text-center">첨부파일</th>
					<td colspan="3">
						<ul>
							<li v-for="(f, index) in filename">
								<a :href="'../board/download.do?fn='+f">{{f}}</a>
								&nbsp;&nbsp;&nbsp;({{filesize[index]}}&nbsp;bytes)
							</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="txt-left" valign="top" height="200">
						<pre style="white-space: pre-wrap; background-color: white; border: none;">{{vo.content}}</pre>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a :href="'../board/update.do?no='+no" class="btn btn-xs btn-warning">수정</a>
						<button @click="del()" type="button" class="btn btn-xs btn-danger">{{isShow?'취소':'삭제'}}</button>
						<a href="../board/list.do" class="btn btn-xs btn-success">목록</a>
					</td>
				</tr>
				<tr id="delTr" v-show="isShow">
					<td colspan="4" class="text-right">
						<input type="password" size="20" v-model="pwd" ref="pwd" class="input input-sm" placeholder="비밀번호">
						<button type="button" class="btn btn-sm btn-primary" ref="deleteBtn" @click="boardDelete()">삭제</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
	let detailApp=Vue.createApp({
		data(){
			return{
				vo:{},
				no:${no},
				filename:[],
				filesize:[],
				isShow:false,
				pwd:''
			}
		},
		mounted(){
			axios.get('../board/vueDetail.do', {
				params:{
					no:this.no
				}
			}).then(response=>{
				this.vo=response.data
				let count=response.data.filecount
				if(count>0){
					this.filename=response.data.filename.split(",")
					this.filesize=response.data.filesize.split(",")
				}
			})
		},
		methods:{
			del(){
				this.isShow=!this.isShow
			},
			boardDelete(){
				if(this.pwd===''){
					alert('비밀번호를 입력하세요')
					this.$refs.pwd.focus()
					return
				}
				axios.get('../board/vueDelete.do', {
					params:{
						no:this.no,
						pwd:this.pwd
					}
				}).then(response=>{
					if(response.data==='OK'){
						location.href='../board/list.do'
					}
					else{
						alert('비밀번호가 틀렸습니다')
						this.$refs.pwd.value=''
						this.$refs.pwd.focus()
					}
				}).catch(error=>{
					alert(error.response)
				})
			}
		}
	}).mount('.container')
	</script>
</body>
</html>