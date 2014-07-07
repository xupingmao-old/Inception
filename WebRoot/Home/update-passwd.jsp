<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>更新头像</title>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/span.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/home.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/infos.css"/>
    <script src="/Inception/Home/js/jquery-1.6.4.min.js"></script>
    
    <style>
    .old_head img
    {
    width:200px;
    height:200px;
    }
    
    .error
    {
    color:red;
    }
    
    .home_main
    {
    height:100%;
    }
    
    .info-main
    {
    margin:0 auto;
    width:500px;
    padding-top:50px;
    }
    </style>
  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    <script>
    setMenu(4);
    </script>
    <div class="home_main">
    
    <div class="info-main">
	   	<s:form >
	   	<table>
	   		<tr><td colspan="2" align="center">修改密码</td></tr>
	   		
	   		<tr><td>原密码</td><td ><s:password name="oldpasswd"/></td></tr>
	   		<tr><td>新密码</td><td ><s:password name="passwd"/></td></tr>
	   		<tr><td>确认密码</td><td ><s:password name="passwd2"/></td></tr>
	   		<tr>
	   			<td colspan="2">
	   			<s:fielderror cssClass="error">
	   				<s:param>error</s:param>
	   			</s:fielderror>
	   			</td>
	   		</tr>
	   		<tr><td colspan="2" align="center"><s:submit value="确认修改"/></td></tr>
	   	</table>
	   	</s:form>
	<br/>
	<a href="/Inception/UserMain.action">返回</a>
	   	</div>
	</div>
  </body>
</html>
