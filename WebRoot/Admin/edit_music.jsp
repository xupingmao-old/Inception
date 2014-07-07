<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
  <head>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="/Inception/Admin/css/add_music.css"/>
    	<jsp:include page="head.jsp"/>
  </head>
  <body>
    <jsp:include page="menu.jsp"/>
      <div class="middle">
      	<s:form action="" enctype="multipart/form-data">
      	<s:textfield name="music.id" cssStyle="display:none"> </s:textfield>
      	<table class="add_div">
      		<tr><td colspan="2" align="center">更新音乐</td></tr>
      		<tr>
      			<td>名称</td>
      			<td><s:textfield name="music.musicName"></s:textfield></td>
      		</tr>
      		<tr>
      			<td>演唱者</td>
      			<td><s:textfield name="music.artistName"/></td>
      		</tr>
      		
      		<tr>
      			<td>类型</td>
      			<td><s:select name="music.musicStyle" list='{"流行","摇滚","民谣","电子","说唱","轻音乐","爵士","乡村","R&B/Soul","古典","民族","英伦","金属","朋克","蓝调","原声","雷鬼","世界音乐","拉丁","另类/独立","动漫","New Age","Bossa Nova","蠢萌"}'/></td>
      		</tr>
      		<tr>
      			<td>语言</td>
      			<td><s:select name="music.musicLanguage" list = '{"国语", "粤语","欧美","韩语","日语","小语种"}'></s:select></td>
      		</tr>
      		<tr>
      			<td>专辑</td>
      			<td><s:select name="music.albumName" list="albumNames"/></td>
      		</tr>
      		<tr>
      			<td>发行日期</td>
      			<td><s:textfield name="music.publishDate" cssClass="easyui-datebox" cssStyle="width:300px"></s:textfield></td>
      		</tr>
      		<tr>
      			<td>简介</td>
      			<td><s:textarea name="music.description" cssStyle="width:300px;" rows="5"></s:textarea></td>
      		</tr>
      		<tr>
      			<td colspan="2" align="center"><s:submit value="确认更新"></s:submit></td>
      		</tr>
      	</table>
      		
      		
      		
      	</s:form>
      </div>
      <div class="footer">
        <span class="introduce">@2014 XuPingmao Group, all rights reserved</span>
      </div>
  </body>
</html>
