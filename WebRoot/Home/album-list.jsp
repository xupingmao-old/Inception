<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>盗梦空间</title>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/span.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/home.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/img.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/album.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/m-info.css"/>
    <script src="/Inception/Home/js/jquery-1.6.4.min.js"></script>
  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    <!-- 专题图片 -->
    <div class="home-main">
	   	<jsp:include page="album-list-body.jsp"/>
	</div>
  </body>
</html>
