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
<script src="image.js"></script>
<script src="page.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<image-card v-bind:list="list" />
		</div>
		<div class="row">
			<page-card v-bind:pageRange="pageRange" />
		</div>
	</div>
	<script>
	let recipeApp=Vue.createApp({
		data(){
			return{
				list:[],
				curPage:1,
				startPage:0,
				endPage:0,
				totalPage:0,
				pageRange:[]
			}
		},
		methods:{
			dataRecv(){
				axios.get('../recipe/vueList.do', {
					params:{
						page:this.curPage
					}
				}).then(response=>{
					this.list=response.data.list
					this.curPage=response.data.curPage
					this.totalPage=response.data.totalPage
					this.endPage=response.data.endPage
					this.startPage=response.data.startPage
					this.makeRange()
				})
			},
			makeRange(){
				this.pageRange=[]
				for(let i=this.startPage;i<=this.endPage;i++){
					this.pageRange.push(i)
				}
			},
			pageChange(page){
				this.curPage=page
				this.dataRecv()
			}
		},
		mounted(){
			this.dataRecv()
		},
		components:{
			'image-card':imageCard,
			'page-card':pageCard
		}
	}).mount('.container')
	</script>
</body>
</html>