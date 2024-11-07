const pageCard={
			props:['pageRange'],
			template: `<ul class="pagination">
				<li v-if="$parent.startPage>1">
					<a class="nav-link" @click="$parent.pageChange($parent.startPage-1)">&lt;</a>
				</li>
				<li v-for="i in $parent.pageRange" :class="{active:$parent.curPage===i}">
					<a class="nav-link" @click="$parent.pageChange(i)">{{i}}</a>
				</li>
				<li v-if="$parent.endPage<$parent.totalPage">
					<a class="nav-link" @click="$parent.pageChange($parent.endPage+1)">&gt;</a>
				</li>
			</ul>`
	}