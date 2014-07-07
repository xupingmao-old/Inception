<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
  <head>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="/Inception/Admin/css/add_music.css"/>
    	<jsp:include page="head.jsp"/>
    <style>
    .img-upload
    {
    	width:300px;
    }
    </style>
  </head>
  <body>
    <jsp:include page="menu.jsp"/>
      <div class="middle">
      	<s:form enctype="multipart/form-data">
      	<table class="add_div">
      		<tr><td colspan="2" align="center">添加专辑</td></tr>
      		<tr>
      			<td>名称</td>
      			<td><s:textfield name="al.albumName"></s:textfield></td>
      		</tr>
      		<tr>
      			<td>简介</td>
      			<td><s:textarea name="al.description" cssStyle="width:300px;"></s:textarea></td>
      		</tr>
      		<tr>
      			<td>演唱者</td>
      			<td><s:textfield name="al.artistName"/></td>
      		</tr>
      		<tr>
      			<td>发行日期</td>
      			<td><s:textfield name="al.publishDate" cssClass="easyui-datebox" cssStyle="width:300px"></s:textfield></td>
      		</tr>
      		<tr>
      			<td>图片文件</td>
      			<td>
      				<s:file name="img" cssClass="img-upload"></s:file>
      				<s:fielderror cssClass="error">
      					<s:param>imageError</s:param>
      				</s:fielderror>
      			</td>
      		</tr>
      		<tr class="error">
      			<td colspan="2">
      				<s:fielderror cssClass="error">
      					<s:param>uploadError</s:param>
      				</s:fielderror>
      			</td>
      		</tr>
      		<tr>
      			<td colspan="2" align="center"><s:submit value="添加"></s:submit></td>
      		</tr>
      	</table>
      		
      		
      		
      	</s:form>
      </div>
      <div class="footer">
        <span class="introduce">@2014 XuPingmao Group, all rights reserved</span>
      </div>
  </body>
</html>
