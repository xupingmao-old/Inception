<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Welcome</title>
		<link rel="stylesheet" type="text/css" href="User/css/denglu.css"/>
		</head>
	<body>
		<h1>Hello, ${id}</h1>
		<table>
			<tr><td colspan="2" align="center">用户信息</td></tr>
			<tr><td>用户名</td><td>${user.userName }</td></tr>
			<tr><td>邮箱</td><td>${user.email }</td></tr>
		</table>
	</body>
</html>