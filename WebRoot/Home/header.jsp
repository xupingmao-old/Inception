<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="header">
	<div id="logo_div">
		<div class="logo_img">
			<a href="/Inception/Home.action">
				<img src="/Inception/Home/images/Music logo-9.jpg" />
				<span>盗梦空间</span>
			</a>
		</div>
	<div class="header_user">
		<s:if test="user == null">
		<span>
			<span><a href="/Inception/User/login.jsp">登录</a></span>|<span><a href="/Inception/User/regist.jsp">注册</a></span>
		</span>
		</s:if>
		<s:else>
			<span><a href="/Inception/UserMain.action" >用户：${user.userName }</a></span>
			<span>|</span>
			<s:if test="user.permission >= 1">
				<span><a href="/Inception/AdminMain.action?start=0">后台管理</a></span>
				<span>|</span>
			</s:if>
			<span><a href="/Inception/Logout.action">退出</a></span>
		</s:else>
	</div>
	<!-- 
	<div class="search_div">
		<input class="search_text" type="text" placeholder="输入搜索内容"/>
		<input type="button" value="搜索"/>
	</div>
	-->
	</div>
	
	<div class="menu_div">
		<div class="menu_items">
			<ul class="menu_nav">
				<li class='selected_item' my_select='true'><a href="/Inception/Home.action" ><em>推荐</em></a></li>
				<li><a href="/Inception/ShowAll.action"><em>分类</em></a></li>
				<li><a href="/Inception/Album.action"><em>专辑</em></a></li>
				<li><a href="/Inception/Play.action"><em>正在播放</em></a></li>
				<li><a href="/Inception/UserMain.action"><em>用户</em></a></li>
				<li><a href="/Inception/UserPrefer.action"><em>收藏</em></a></li>
			</ul>
		</div>
	</div>
	
	<script>
$(function(){
	$(".menu_nav li").hover(function(){
		$(this).addClass('selected_item');
	}, function(){
		//console.log($(this).attr('my_select'));
		if( $(this).attr('my_select') != 'true'){
			$(this).removeClass('selected_item');
		}
	})
})

function setMenu(n){
	$(".menu_nav li").attr("my_select", "");
	$(".menu_nav li").attr("class", "");
	var s = $(".menu_nav li")[n];
	$(s).attr("my_select", "true");
	$(s).attr("class", "selected_item");
}
	</script>
	
</div>
