const imageCard={
			props:['list'],
			template:`
			<div class="col-md-4" v-for="vo in list">
				<div class="thumbnail">
					<a :href="'../food/detail.do?fno='+vo.fno">
						<img :src="vo.poster" alt="Lights" style="width: 230px; height: 130px;">
						<div class="caption">
							<p>{{vo.name}}</p>
						</div>
					</a>
				</div>
			</div>`
	}
	