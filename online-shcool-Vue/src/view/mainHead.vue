<template>

<div class="nav nav-default ">
    <ul class="nav-menu-left">
        <li class="nav-menu-item ktplogo ">
            <a class="ketangpaitophref" href="/Index/index">
            	
            </a>
        </li>
        <li class="nav-menu-item"><a href="/Main/index.html" class="active">课堂</a></li>
       
        <li class="nav-menu-item"><a href="/Resource/index.html">备课区</a></li>
       
        <li class="nav-menu-item jingpin" data-yy="0"><a href="/ExcellentResources/index.html?type=1">精品专区</a></li>
        <li class="nav-menu-item"><a href="/Mooc/Mooc/index.html">我的精品</a></li>
        
    </ul>


    <ul class="nav-menu-right">
   
        <li class="paper-repeat nav-menu-item">
		      <a href="/PaperCheckrepeat/index.html">
			      <i>论文查重</i>
		      </a>
	      </li>

	      <li class="addtea nav-menu-item ">
			    <a href="/InviteRecord/inviteteacher">
				    <i class="addteacher">邀请教师</i>
		    	</a>
		    </li>

        <li class="nav-menu-item ico notice nav-mian-margin">
	        <a id="notice" 　href="javascript:;">
		        <i class="iconfont iconxiaoxi1"></i>	
	        </a>
	        
          <div class="notice-ct hide notice-new-ct" style="display: none;">
						  <p class="zw">暂无新通知</p>		
              <div class="bt-bar">
			          <div class="more operation-more">
				          <a id="ignore-all" class="operation-more-ingoreall" href="javascript:void(0);">全部标记已读</a>
				          <a class="link operation-more-ink" href="/Message/index.html">查看全部</a>
			          </div>
		          </div>
	        </div>
        </li>  

        <li>
             <span style="float:left; font-size: 30px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>开通VIP</el-dropdown-item>
                        <el-dropdown-item>设置</el-dropdown-item>
                        <el-dropdown-item><el-button @click="exitSystem()" type="text">退出登陆</el-button></el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span></span>
            </span>
        </li> 
         
    </ul>

   </div>    
 
</template>
<script>
export default {
    name: 'mainHead'
}
</script>
<style scoped>
.title {
    padding-top:1.5%
}


.nav-menu-left {
    margin-left: 0;
    margin-top: 5px;
    float: left;
}
li, ul {
    list-style: none;
}

.nav-menu-item a {
    color: 
    #5F6368;
}
.nav, .nav-menu-item a {
    font-size: 16px;
}
a {
    text-decoration: none;
}
.nav-menu-item {
    margin: 18px;
        margin-right: 18px;
        margin-left: 18px;
    float: left;
    color: 
    #FFF;
    position: relative;
    height: 27px;
    line-height: 27px;
}
.nav-menu-right {
    float: right;
}

.paper-repeat {
    margin-top: 16px;
}

.nav, .nav-menu-item a {
    font-size: 30px;
}

.addtea {
    margin-top: 10px;
}

.nav-menu-item.ico, .nav-menu-item.search {
    margin-left: 7px;
    margin-right: 10px;
}
</style>