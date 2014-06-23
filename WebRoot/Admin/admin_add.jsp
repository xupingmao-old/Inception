<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>添加用户</title>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" style="text/css" href="bootstrap-3.1.1-dist/css/bootstrap.min.css"/>
</head>
<body>
	<s:form action="AdminAdd.action">
	 <table>
		<tr><td colspan="2" align="center">添加用户</td></tr>
		<tr><td>邮箱</td><td><s:textfield name="email" label="邮箱" /></td></tr>
		<tr><td>密码</td><td><s:password name="passwd" label="密码"/></td></tr>
		<tr><td colspan="2" align="center"><s:submit value="提交"/></td></tr>
	</table>
	</s:form>
</body>
</html>