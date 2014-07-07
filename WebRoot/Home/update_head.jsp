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
    <link rel="shortcut icon" href="/Inception/icon.ico" >
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
    
    </style>
  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    <script>
    setMenu(4);
    </script>
    <div class="home_main">
	   	<s:form enctype="multipart/form-data">
	   	<h3>原头像</h3>
	   	<div class="old_head">
	   		<img src="/Inception/HeadServlet?url=${user.imageUrl }"/>
	   	</div>
	   	<s:fielderror  cssClass="error">
	   	<param name="error"/>
	   	</s:fielderror>
	   		<s:file name="upload"/>
	   		<br/>
	   		<s:submit value="确认"/>
	   	</s:form>
	<br/>
	<a href="/Inception/UserMain.action">返回</a>
	</div>
  </body>
</html>
