<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>管理员</title>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" style="text/css" href="bootstrap-3.1.1-dist/css/bootstrap.min.css"/>
<style>
	.userList {
		width:600px;
	}
</style>
</head>
<body>
<!-- 
<s:bean name="org.apache.struts2.util.Counter" id="counter">
   <s:param name="first" value="1" />
   <s:param name="last" value="10" />
   <s:iterator>
     counter:<s:property/>
   </s:iterator>
</s:bean>
-->

<div class="userList">
<table class="table">
<tr><td colspan="5" align="center"><h2>所有用户</h2></td></tr>
<tr><td width="120">用户名</td><td width="200">注册邮箱</td><td>用户类型</td><td>注册时间</td><td>密码</td></tr>
	<s:iterator value="list">
		<tr>
			<td><s:property value="userName"/></td>
			<td><s:property value="email"/></td>
			<td><s:property value="userType"/></td>
			<td><s:property value="registDate"/></td>
			<td><s:property value="passwd"/></td>
		</tr>
	</s:iterator>
</table>
</div>
<p><a href="admin_add.jsp">添加用户</a></p>
</body>
</html>