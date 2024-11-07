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
	margin-bottom: 20px !important;
}

button[type=button] {
	margin: 0px 5px;
}

.a {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
<script src="http://unpkg.com/vue@3"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<button @click="changeType('')" type="button" class="btn btn-sm btn-default">전체</button>
			<button @click="changeType('한식')" type="button" class="btn btn-sm btn-info">한식</button>
			<button @click="changeType('중식')" type="button" class="btn btn-sm btn-success">중식</button>
			<button @click="changeType('일식')" type="button" class="btn btn-sm btn-warning">일식</button>
			<button @click="changeType('양식')" type="button" class="btn btn-sm btn-danger">양식</button>
			<button @click="changeType('분식')" type="button" class="btn btn-sm btn-primary">분식</button>
		</div>
		<div class="row">
			<div class="col-sm-3 text-center" v-for="vo in list">
				<a :href="'../food/detail.do?fno='+vo.fno+'&page='+curPage+'&type='+type">
					<div class="thumbnail">
						<img :src="'http://www.menupan.com'+vo.poster">
					</div>
					<div class="caption">
						<p class="a">{{vo.name}}</p>
					</div>
				</a>
			</div>
		</div>
		<div class="row text-center">
			<ul class="pagination">
				<li v-if="startPage>1">
					<a @click="changePage(startPage-1)">&lt;</a>
				</li>
				<li :class="{active:curPage===i}" v-for="i in pageRange">
					<a @click="changePage(i)">{{i}}</a>
				</li>
				<li v-if="endPage<totalPage">
					<a @click="changePage(endPage+1)">&gt;</a>
				</li>
			</ul>
		</div>
	</div>
	<script>
	let typetmp="${type}"
	let foodApp=Vue.createApp({
		data(){
			return{
				curPage:${page},
				totalPage:0,
				startPage:0,
				endPage:0,
				list:[],
				type:typetmp||'',
				pageRange:[]
			}
		},
		methods:{
			makePage(){
				this.pageRange=[]
				for(let i=this.startPage;i<=this.endPage;i++){
					this.pageRange.push(i)
				}
			},
			foodList(){
				axios.get('../food/vueList.do', {
					params:{
						page:this.curPage,
						type:this.type
					}
				}).then(response=>{
					this.list=response.data.list
					this.curPage=response.data.curPage
					this.totalPage=response.data.totalPage
					this.startPage=response.data.startPage
					this.endPage=response.data.endPage
					this.makePage()
				})
			},
			changePage(page){
				this.curPage=page
				this.foodList()
			},
			changeType(type){
				this.type=type
				this.curPage=1
				this.foodList()
			}
		},
		mounted(){
			this.foodList()
		}
	}).mount('.container')
	</script>
</body>
</html>