<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户收藏</title>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/span.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/home.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/infos.css"/>
    <link rel="shortcut icon" href="/Inception/icon.png" >
    <script src="/Inception/Home/js/jquery-1.6.4.min.js"></script>
    
    <style>
    .prefer-list
    {
    padding-left:20px;
    padding-top:20px;
    }
    .prefer-list td
    {
    padding-top:10px;
    }
    </style>
  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    <!-- 专题图片 -->
    <div class="home_main">
	   	<script>
	   	setMenu(5);
	   	</script>
	   	<div class='prefer-list'>
	   		<table>
	   			<tr><td>乐曲名</td><td>删除</td></tr>
		   		<s:iterator value="list">
		   			<tr><td><a href='/Inception/Play.action?url=<s:property value='music.musicUrl'/>'>
		   				<s:property value="music.musicName"/></a></td>
		   			<td><a href='/Inception/DelPrefer.action?id=<s:property value="id"/>'>删除</a></td>		
		   		</tr>
		   		</s:iterator>
	   		</table>
	   		<br/>
	   		<a href="/Inception/PlayAllPrefer.action">播放所有</a>
	   	</div>
	<br/>
	<br/>
	<br/>
	<jsp:include page="pages.jsp"></jsp:include>
	</div>
  </body>
</html>
