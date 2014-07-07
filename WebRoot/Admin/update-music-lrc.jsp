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
    	.old-lrc
    	{
    	background:#ccc;
    	color:blue;
    	}
    </style>
  </head>
  <body>
    <jsp:include page="menu.jsp"/>
      <div class="middle">
      	<h3><a href="/Inception/Play.action?url=${url }">${name }</a>原歌词</h3>
      	<br/>
      	<p id = "old-lrc">${lrc }</p>
      	<br/>
      	<script>
      		var html = $("#old-lrc").html();
      		html = html.split("\n");
      		var hhh="";
      		for(var i = 0; i < html.length; i++){
      			hhh += html[i] + "<br/>";
      		}
      		$("#old-lrc").html(hhh);
      	</script>
      	<s:form  enctype="multipart/form-data">
      		<s:textfield name="music.id" cssClass="hidden"> </s:textfield>
      		<s:textfield name="music.imageUrl" cssClass="hidden"> </s:textfield>
      			<p > 请上传lrc或txt格式歌词</p>
      			<s:file name="upload"/>
      			<s:fielderror cssClass="error">
      				<s:param>error</s:param>
      			</s:fielderror>
      			<br/>
      			<br/>
      			<s:submit value="更新"/>
      	</s:form>
      </div>
      <div class="footer">
        <span class="introduce">@2014 XuPingmao Group, all rights reserved</span>
      </div>
  </body>
</html>
