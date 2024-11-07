<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px
}

.row {
	margin: 0px auto;
	width: 960px
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-center" colspan="3"><img :src="detail.poster" style="width: 800px; height: 200px"></td>
				</tr>
				<tr>
					<td class="text-center" colspan="3"><h3>{{detail.title}}</h3></td>
				</tr>
				<tr>
					<td class="text-center" colspan="3">{{detail.content}}</td>
				</tr>
				<tr>
					<td class="text-center"><img src="../img/a1.png"></td>
					<td class="text-center"><img src="../img/a2.png"></td>
					<td class="text-center"><img src="../img/a3.png"></td>
				</tr>
				<tr>
					<td class="text-center">{{detail.info1}}</td>
					<td class="text-center">{{detail.info2}}</td>
					<td class="text-center">{{detail.info3}}</td>
				</tr>
			</table>
			<h3>[재료]</h3>
			<table class="table">
				<tr>
					<td>
						<ul style="list-style-type: none">
							<li v-for="d in data">{{d}}</li>
						</ul>
					</td>
				</tr>
			</table>
			<h3>[조리순서]</h3>
			<table class="table">
				<tr>
					<td>
						<table class="table" v-for="(m,index) in makes">
							<tr>
								<td class="text-left" width="80%">{{m}}</td>
								<td class="text-right" width="20%"><img :src="images[index]" style="width: 150px; height: 80px"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<h3>[레시피 작성자]</h3>
			<table class="table">
				<tr>
					<td width=20% class="text-center" rowspan="2"><img :src="detail.chef_poster" style="width: 100px; height: 100px" class="img-circle"></td>
					<td width=80%>{{detail.chef}}</td>
				</tr>
				<tr>
					<td width=80%>{{detail.chef_profile}}</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
   let detailApp=Vue.createApp({
	   data(){
		   return {
			   no:${no},
			   detail:{},
			   images:[],
			   makes:[],
			   data:[]
		   }
	   },
	   mounted(){
		   axios.get('../recipe/vueDetail.do',{
			   params:{
				   no:this.no
			   }
		   }).then(response=>{
			   console.log(response.data)
			   this.detail=response.data.detail
			   this.images=response.data.iList
			   this.makes=response.data.sList
			   this.data=response.data.detail.data.split(',')
		   })
	   }
   }).mount('.container')
  </script>
</body>
</html>