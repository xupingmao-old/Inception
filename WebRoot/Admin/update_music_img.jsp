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
    	width:200px;
    	height:200px;
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
      	<s:form enctype="multipart/form-data">
		<h2><a href="/Inception/Play.action?url=${url }">${name }</a>:旧图片</h2>
      		<div class='img_div'>
      			<img src="/Inception/ImageServlet?url=${ imgUrl }"/>
      		</div>
      		<div>
      		<s:textfield name="music.id" cssClass="hidden"> </s:textfield>
      		<s:textfield name="music.imageUrl" cssClass="hidden"> </s:textfield>
      		<s:textfield name="music.musicName" cssClass="hidden"> </s:textfield>
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
