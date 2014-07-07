<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
  <head>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="/Inception/Admin/css/add_music.css"/>
    	<jsp:include page="head.jsp"/>
    	
    <style>
    	.img_div img
    	{
    	width:600px;
    	height:275px;
    	}
    	.error
    	{
    	color:red;
    	}
    	.hidden
    	{
    	display:none;
    	}
    </style>
  </head>
  <body>
    <jsp:include page="menu.jsp"/>
      <div class="middle">
      	<s:form  enctype="multipart/form-data">
      	<p>姓名：<s:textfield name="name"></s:textfield></p>
      	<p>简介：<s:textfield name="description"></s:textfield></p>
		<h2>旧图片</h2>
      		<div class='img_div'>
      			<img src="/Inception/AlbumImageServlet?url=${url}"/>
      		</div>
      		<div>
      			<p > 请上传jpg或png或gif格式图片</p>
      			<s:file name="upload"/>
      			<s:fielderror cssClass="error">
      				<s:param>error</s:param>
      			</s:fielderror>
      			<br/>
      			<br/>
      			<s:submit value="更新"/>
      		</div>
      	</s:form>
      </div>
      <div class="footer">
        <span class="introduce">@2014 XuPingmao Group, all rights reserved</span>
      </div>
  </body>
</html>
