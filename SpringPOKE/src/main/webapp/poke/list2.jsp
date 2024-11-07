<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script type="text/javascript" src="http://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<label v-for="type in types" style="margin: 0px 25px auto;" @change="pokeList(1, ss, typeCheck)"><input type="checkbox" :value="type"  v-model="typeCheck"><img :src="'../image/'+type+'.png'" style="height: 20px; width: 20px;">{{type}}</label>
		</div>
		<div class="row">
			<div class="col-sm-3" v-for="vo in list">
				<div class="thumbnail">
					<a><img :src="vo.poster"></a>
				</div>
				<p>
					<a>{{vo.name}}<small style="color: #aaa;">&nbsp;{{vo.form}}</small></a>
				</p>
			</div>
		</div>
		<div style="height: 20px;"></div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<li v-if="startPage>1">
						<a v-on:click="pokeList(startPage-1, ss, typeCheck)">&lt;</a>
					</li>
					<li :class="{active:curPage===number}" v-for="number in pageRange" :key="number">
						<a v-on:click="pokeList(number, ss, typeCheck)">{{number}}</a>
					</li>
					<li v-if="endPage<totalPage">
						<a v-on:click="pokeList(endPage+1, ss, typeCheck)">&gt;</a>
					</li>
				</ul>
			</div>
			<div class="text-center" style="margin-bottom: 30px;">
				<input v-on:keyup.enter="pokeList(1, fd, typeCheck)" type="text" name="ss" size="15" class="input input-sm" v-model="fd">
				<button type="button" v-on:click="pokeList(1, fd, typeCheck)" class="btn btn-sm btn-info">검색</button>
			</div>
		</div>
	</div>
	<script>
	let app=Vue.createApp({
		data(){
			return{
				list:[],
				startPage:1,
				endPage:10,
				totalPage:0,
				ss:'',
				curPage:1,
				fd:'',
				types:[],
				typeCheck:[]
			}
		},
		computed:{
			pageRange(){
				let length=this.endPage-this.startPage+1
				return Array.from({length}, (_,i)=>this.startPage+i)
			}
		},
		methods:{
			pokeList(page, ss, typeCheck){
				this.curPage=page
				this.fd=''
				this.ss=ss
				let typeStr=''
				if(typeCheck!=null){
					typeStr=typeCheck.join('|')
				}
				axios.get('../poke/list2.do', {
					params:{
						page:page,
						ss:ss,
						type:typeStr
					}
				}).then(response=>{
					console.log(response)
					this.list=response.data.list
					this.startPage=response.data.startPage
					this.endPage=response.data.endPage
					this.totalPage=response.data.totalPage
					this.types=response.data.types
				})
			}
		},
		mounted(){
			this.pokeList(1, this.ss)
		}
	}).mount('.container')
	</script>
</body>
</html>