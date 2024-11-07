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
	margin: 0px auto;
	width: 1100px;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="http://unpkg.com/vue@3"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">자유게시판</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width="10%" class="text-center">번호</th>
					<th width="45%" class="text-center">제목</th>
					<th width="20%" class="text-center">이름</th>
					<th width="15%" class="text-center">작성일</th>
					<th width="10%" class="text-center">조회수</th>
				</tr>
				<tr v-for="(vo, index) in list">
					<td class="text-center">{{count-index}}</td>
					<td><a :href="'../board/detail.do?no='+vo.no">{{vo.subject}}</a></td>
					<td class="text-center">{{vo.name}}</td>
					<td class="text-center">{{vo.dbday}}</td>
					<td class="text-center">{{vo.hit}}</td>
				</tr>
				<tr>
					<td colspan="5" class="text-center">
						<button @click="boardList(curPage>1?curPage-1:curPage)" type="button" class="btn btn-sm btn-info">&lt;</button>
						{{curPage}}page/{{totalPage}}page
						<button @click="boardList(curPage<totalPage?curPage+1:curPage)" type="button" class="btn btn-sm btn-primary">&gt;</button>
					</td>
				</tr>
				<tr>
				<td colspan="5" class="text-right">
				<a href="../board/insert.do" class="btn btn-sm btn-success">글쓰기</a>
				</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
	let boardApp=Vue.createApp({
		data(){
			return{
				list:[],
				curPage:1,
				totalPage:0,
				count:0
			}
		},
		methods:{
			boardList(page){
				axios.get('../board/vueList.do', {
					params:{
						page:page
					}
				}).then(response=>{
					console.log(response.data)
					this.list=response.data.list
					this.curPage=response.data.curPage
					this.totalPage=response.data.totalPage
					this.count=response.data.count
				})
			}
		},
		mounted(){
			this.boardList(1)
		}
	}).mount('.container')
	</script>
</body>
</html>