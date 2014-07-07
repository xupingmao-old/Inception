<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="main" style="overflow:hidden;">
	<div class="user_icon">
		<div><img src="/Inception/HeadServlet?url=${user.imageUrl }"/></div>
		<div>
			<a style="padding-left:50px;" href="/Inception/UpdateHead.action">更新用户头像</a>
		</div>
	</div>

<div class="info_div">
	<table>
		<tr><td colspan="2" align="center">用户信息</td></tr>
		<tr><td>用户名</td><td><s:label name="user.userName"/></td></tr>
		<tr><td>邮箱</td><td><s:label name="user.email"></s:label></td></tr>
		<tr><td>性别</td><td><s:label  name="user.sSex" /></td></tr>
		<tr><td>注册时间</td><td><s:label name="user.registDate"/></td></tr>
		<tr><td>权限</td><td><s:label name="user.sPermission"/></td></tr>
		<tr><td><a href="/Inception/UserUpdate.action" >修改个人信息</a></td>
		<td><a href="/Inception/UpdatePasswd.action">修改密码</a></td></tr>
	</table>
</div>

<div class="history_div">
<h3>
	听歌历史
</h3>
<s:iterator value="historyList">
	<div class="history_entry">
		<a href='/Inception/Play.action?url=<s:property value="musicUrl"/>&uid=${user.id}'>
			<span class="entry_title"><s:property value="musicName"/></span>
		</a>
		<span class="entry_date"><s:property value="historyDate"/></span>
	</div>
</s:iterator>
<br/>
<br/>
<a href="/Inception/UserHistory.action">查看所有</a>
</div>
</div>

<script>
setMenu(4);
</script>