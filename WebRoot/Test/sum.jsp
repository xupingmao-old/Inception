<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>���������</title>
</head>
<body>
�������
<br/>
<s:form action="/Sum.action" >
<s:textfield name="operand1" label=" ������1"/>
<s:textfield name="operand2" label=" ������2" />
<!-- 
������1��<s:textfield name="operand1"/>
������2��<s:textfield name="operand2"/>
<s:submit value="������" />
��ʾ��
������1
������2
input
input
-->
<s:submit value="������"></s:submit>
</s:form>
</body>
</html>