<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://unpkg.com/vue@3"></script>
<script type="text/javascript" src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="row" id="boardApp">
		<h3 class="text-center">게시판</h3>
		<table class="table">
			<tr>
				<th width="10%" class="text-center">번호</th>
				<th width="45%" class="text-center">제목</th>
				<th width="15%" class="text-center">이름</th>
				<th width="20%" class="text-center">작성일</th>
				<th width="10%" class="text-center">조회수</th>
			</tr>
			<tr v-for="vo in boardList">
				<td width="10%" class="text-center" v-text="vo.no"></td>
				<td width="45%">{{vo.subject}}</td>
				<td width="15%" class="text-center">{{vo.name}}</td>
				<td width="20%" class="text-center">{{vo.dbday}}</td>
				<td width="10%" class="text-center">{{vo.hit}}</td>
			</tr>
			<tr>
				<td colspan="5" class="text-right"><a href="../board/insert.do" class="btn btn-sm btn-primary">글작성</a></td>
			</tr>
			<tr>
				<td colspan="5" class="text-center"><input type="text" size="20" id="fd" class="input input-sm" v-model="message">
					<button type="button" class="btn btn-sm btn-success">검색</button></td>
			</tr>
			<tr>
				<td colspan="5">{{message}}</td>
			</tr>
			<tr>
				<td colspan="5" class="text-center">
					<button type="button" class="btn btn-sm btn-warning">이전</button> {{curPage}}page/{{totalPage}}page
					<button type="button" class="btn btn-sm btn-warning">다음</button>
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
	let boardApp=Vue.createApp({
		data(){
			return {
				boardAll:{},
				boardList:[],
				curPage:1,
				totalPage:0,
				message:''
			}
		},
		mounted(){
			axios.get('../board/listVue.do',{
			params:{
				page:this.curPage
			}
			}).then(response=>{
				console.log(response.data)
				this.boardAll=response.data
				this.boardList=response.data.list
				this.curPage=response.data.curPage
				this.totalPage=response.data.totalPage
			})
		}
	}).mount('#boardApp')
	</script>
</body>
</html>