<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>����û�</title>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" style="text/css" href="bootstrap-3.1.1-dist/css/bootstrap.min.css"/>
</head>
<body>
	<s:form action="AdminAdd.action">
	 <table>
		<tr><td colspan="2" align="center">����û�</td></tr>
		<tr><td>����</td><td><s:textfield name="email" label="����" /></td></tr>
		<tr><td>����</td><td><s:password name="passwd" label="����"/></td></tr>
		<tr><td colspan="2" align="center"><s:submit value="�ύ"/></td></tr>
	</table>
	</s:form>
</body>
</html>