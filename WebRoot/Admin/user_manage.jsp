<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
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
  </body>
</html>
