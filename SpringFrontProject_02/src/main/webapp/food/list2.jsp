<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 1100px;
}

p {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.link{
cursor: pointer;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<script type="text/javascript" src="http://unpkg.com/vue@3"></script>
<script type="text/javascript" src="http://unpkg.com/axios/dist/axios.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-3" v-for="vo in list">
				<div class="thumbnail">
					<img :src="'http://www.menupan.com'+vo.poster">
				</div>
				<div class="caption">
					<p>{{vo.name}}</p>
				</div>
			</div>
		</div>
		<div style="height: 10px;"></div>
		<div class="row text-center">
		<ul class="pagination">
		<li v-if="startPage>1"><a @click="print(startPage-1)" class="link">&lt;</a></li>
		<li :class="{active:curPage===i}" v-for="i in range(startPage, endPage)"><a @click="print(i)" class="link">{{i}}</a></li>
		<li v-if="endPage<totalPage"><a @click="print(endPage+1)" class="link">&gt;</a></li>
		</ul>
		</div>
	</div>
	<script>
	let app=Vue.createApp({
		data(){
			return{
				list:[],
				curPage:1,
				startPage:0,
				endPage:0,
				totalPage:0
			}
		},
		mounted(){
			this.print(1)
		},
		methods:{
			print(page){
				axios.get('../food/listVue.do', {
					params:{
						page:page
					}
				}).then(response=>{
					this.list=response.data.list
					this.curPage=response.data.curPage
					this.startPage=response.data.startPage
					this.endPage=response.data.endPage
					this.totalPage=response.data.totalPage
				})
			},
			range(start, end){
				let arr=[]
				let len=end-start
				for(let i=0;i<=len;i++){
					arr[i]=start+i
				}
				return arr
			}
		}
	}).mount('.container')
	</script>
</body>
</html>