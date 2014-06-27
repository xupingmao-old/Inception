<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>盗梦空间</title>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/span.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/home.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/img.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/recommend.css"/>
    <link rel="stylesheet" type="text/css" href="/Inception/Home/css/hot.css"/>
    <script src="/Inception/Home/js/jquery-1.6.4.min.js"></script>
  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    <!-- 专题图片 -->
    <jsp:include page="img_show.jsp"/>
    <div class="home_main">
	    <!-- 主体内容-->
		<jsp:include page="recommend.jsp"/>
		<!-- 热门 -->
		<jsp:include page="hot.jsp"/>
	</div>
  </body>
</html>
