<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>输入操作数</title>
</head>
<body>
求代数和
<br/>
<s:form action="/Sum.action" >
<s:textfield name="operand1" label=" 操作数1"/>
<s:textfield name="operand2" label=" 操作数2" />
<!-- 
操作数1：<s:textfield name="operand1"/>
操作数2：<s:textfield name="operand2"/>
<s:submit value="代数和" />
显示是
操作数1
操作数2
input
input
-->
<s:submit value="代数和"></s:submit>
</s:form>
</body>
</html>