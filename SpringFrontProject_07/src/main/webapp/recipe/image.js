const imageCard={
			props:['list'],
			template:`
			<div class="col-md-3" v-for="vo in list">
				<div class="thumbnail">
					<a :href="'../recipe/detail.do?no='+vo.no">
						<img :src="vo.poster" alt="Lights" style="width: 230px; height: 130px;">
						<div class="caption">
							<p>{{vo.title}}</p>
						</div>
					</a>
				</div>
			</div>`
	}
	