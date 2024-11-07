<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</style>
<script src="http://unpkg.com/vue@3"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<table>
				<tr>
					<td v-for="img in imgs" class="text-center"><img :src="'http://www.menupan.com'+img" style="width: 150px; height: 100px;"></td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td width="30%" class="text-center" rowspan="8"><img :src="'http://www.menupan.com'+vo.poster" style="width: 100%"></td>
					<td colspan="2">
						<h3>
							{{vo.name}}&nbsp;<span style="color: orange;">{{vo.score}}</span>
						</h3>
					</td>
				</tr>
				<tr>
					<td class="text-right" width="15%">주소</td>
					<td width="55%">{{vo.address}}</td>
				</tr>
				<tr>
					<td class="text-right" width="15%">전화</td>
					<td width="55%">{{vo.phone}}</td>
				</tr>
				<tr>
					<td class="text-right" width="15%">음식종류</td>
					<td width="55%">{{vo.type}}</td>
				</tr>
				<tr>
					<td class="text-right" width="15%">주차</td>
					<td width="55%">{{vo.parking}}</td>
				</tr>
				<tr>
					<td class="text-right" width="15%">영업시간</td>
					<td width="55%">{{vo.time}}</td>
				</tr>
				<tr>
					<td class="text-right" width="15%">테마</td>
					<td width="55%">{{vo.theme}}</td>
				</tr>
				<tr>
					<td class="text-right" width="15%">조회수</td>
					<td width="55%">{{vo.hit}}</td>
				</tr>
				<tr></tr>
			</table>
			<table class="table">
				<tr>
					<td>{{vo.content}}</td>
				</tr>
				<tr>
					<td class="text-right"><a :href="'../food/list.do?page='+page+'&type='+type" type="button" class="btn btn-sm btn-info">목록</a></td>
				</tr>
			</table>
		</div>
		<div style="height: 10px;"></div>
		<div class="row">
			<div id="map" style="width: 100%; height: 350px;"></div>
		</div>
		<div style="height: 10px;"></div>
		<div class="row">
			<h3>주변 맛집</h3>
			<hr>
			<table class="table">
				<tr>
					<td v-for="fvo in near_list" class="text-center"><a v-if="fvo.name!==name"
							:href="'../food/detail.do?fno='+fvo.fno+'&page='+page+'&type='+type">
							<img :src="'http://www.menupan.com'+fvo.poster" :title="fvo.address" style="width: 150px; height: 100px;">
						</a></td>
				</tr>
				<tr>
					<td v-for="fvo in near_list" class="text-center"><a v-if="fvo.name!==name"
							:href="'../food/detail.do?fno='+fvo.fno+'&page='+page+'&type='+type">
							{{fvo.name}}
						</a></td>
				</tr>
			</table>
		</div>
	</div>
	<script>
	let typetmp="${type}"
	let detailApp=Vue.createApp({
		data(){
			return{
				vo:{},
				page:${page},
				fno:${fno},
				type:typetmp||'',
				address:'',
				imgs:[],
				near_list:[],
				name:''
			}
		},
		mounted(){
			axios.get('../food/vueDetail.do', {
				params:{
					fno:this.fno
				}
			}).then(response=>{
				console.log(response.data)
				this.vo=response.data.vo
				this.address=response.data.address
				this.imgs=response.data.vo.images.split("^")
				this.near_list=response.data.near_list
				this.name=response.data.vo.name
			if(window.kakao&&window.kakao.map){
				this.initMap()
			}
			else{
				this.addScript()
			}
			})
		},
		methods:{
			addScript(){
				   const script=document.createElement("script")
				   script.onload=()=>kakao.maps.load(this.initMap)
				   script.src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=4e5e9b716ff5c97c5d1fe82f3cebfb53&libraries=services"
				   document.head.appendChild(script)
			   },
			   initMap(){
				   let name=this.vo.name
				   let address=this.address
				   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
				        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };  

				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption); 

				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();

				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(address, function(result, status) {

				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {

				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });

				        // 인포윈도우로 장소에 대한 설명을 표시합니다
				        var infowindow = new kakao.maps.InfoWindow({
				            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
				        });
				        infowindow.open(map, marker);

				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});   
			 }
		}
	}).mount('.container')
	</script>
</body>
</html>