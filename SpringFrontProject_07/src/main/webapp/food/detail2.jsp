<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery.min.js"></script>
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
</head>
<body>
	<div class="container">
		<h3>상세보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td width="30%" rowspan="8" class="text-center"><img :src="'http://www.menupan.com'+detail.poster" style="width: 240px; height: 160px;">
					</td>
					<td colspan="2"><h3>
							{{detail.name}}&nbsp;<span style="color: orange;">{{detail.socre}}</span>
						</h3></td>
				</tr>
				<tr>
					<td style="color: gray;" width="20%">음식종류</td>
					<td width="50%">{{detail.type}}</td>
				</tr>
				<tr>
					<td style="color: gray;" width="20%">주소</td>
					<td width="50%">{{detail.address}}</td>
				</tr>
				<tr>
					<td style="color: gray;" width="20%">전화</td>
					<td width="50%">{{detail.phone}}</td>
				</tr>
				<tr>
					<td style="color: gray;" width="20%">영업시간</td>
					<td width="50%">{{detail.time}}</td>
				</tr>
				<tr>
					<td style="color: gray;" width="20%">주차</td>
					<td width="50%">{{detail.parking}}</td>
				</tr>
				<tr>
					<td style="color: gray;" width="20%">테마</td>
					<td width="50%">{{detail.theme}}</td>
				</tr>
				<tr>
					<td style="color: gray;" width="20%">조회수</td>
					<td width="50%">{{detail.hit}}</td>
				</tr>
			</table>
		</div>
		<hr>
		<div class="row">
			<table class="table" v-for="rvo in replyList">
				<tr>
					<td width="80%" class="text-left">{{rvo.name}}&nbsp;&nbsp;&nbsp;{{rvo.dbday}}</td>
					<td width="20%" class="text-right"><span v-if="rvo.id==sessionId">
							<button type="button" class="btn btn-xs btn-warning ups" :data-rno="rvo.rno">수정</button>&nbsp;
							<button type="button" class="btn btn-xs btn-danger" @click="replyDelete(rvo.rno)">삭제</button>
					</span></td>
				</tr>
				<tr>
					<td colspan="2"><pre style="white-space: pre-wrap; background: white; border: none;">{{rvo.msg}}</pre></td>
				</tr>
				<tr class="updates" style="display: none;" :id="'u'+rvo.rno">
					<td><textarea rows="3" cols="60" style="background: white; float: left; resize: none;">{{rvo.msg}}</textarea>
						<button type="button" style="float: left; width: 84px; height: 66px;" class="bg-primary" @click="replyUpdate(rvo.rno)">수정</button></td>
				</tr>
			</table>
			<table class="table" v-if="sessionId!=''">
				<tr>
					<td><textarea rows="3" cols="60" style="background: white; float: left; resize: none;" ref="msg" v-model="msg"></textarea>
						<button type="button" style="float: left; width: 84px; height: 66px;" class="bg-primary" @click="replyInsert()">작성</button></td>
				</tr>
			</table>
		</div>
	</div>
	<script>
	let detailApp=Vue.createApp({
		data(){
			return{
				detail:{},
				fno:${fno},
				sessionId:'${id}',
				replyList:[],
				msg:'',
				isUps:false
			}
		},
		mounted(){
			let this_=this
			$(document).on('click', '.ups', function() {
				let rno=$(this).attr("data-rno")
				console.log(rno)
				if(this_.isUps===false){
					this_.isUps=true
					$(this).val('취소')
					$('#u'+rno).show()
				}
				else{
					this_.isUps=false
					$(this_).val('수정')
					$('#u'+rno).hide()
				}
			})
			axios.get('../food/vueDetail.do', {
				params:{
					fno:this.fno
				}
			}).then(response=>{
				this.detail=response.data
				this.replyPrint()
			})
		},
		methods:{
			replyPrint(){
				axios.get('../reply/vueReplyList.do', {
					params:{
						fno:this.fno
					}
				}).then(response=>{
					this.replyList=response.data
				})
			},
			replyInsert(){
				if(this.msg===''){
					this.$refs.msg.focus()
					return
				}
				axios.post('../reply/vueReplyInsert.do', null, {
					params:{
						fno:this.fno,
						msg:this.msg
					}
				}).then(response=>{
					this.msg=''
					this.replyPrint()
				})
			},
			replyDelete(rno){
				axios.get('../reply/vueReplyDelete.do',{
					params:{
						rno:rno
					}
				}).then(response=>{
					this.replyPrint()
				})
			}
		}
	}).mount('.container')
	</script>
</body>
</html>