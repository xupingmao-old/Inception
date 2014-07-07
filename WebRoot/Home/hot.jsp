<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="hot_div">
	<div class="hot_title">
		<span>热门歌曲</span>
		<hr/>
	</div>
	<div class="hot_music_list">
		<s:iterator value="hotList">
		<p>
			<a href='/Inception/Play.action?url=<s:property value="musicUrl"/>'>
				<s:property value="musicName"/>
			</a>
			<span class="hot_music_ctr"><s:property value="CTR"/></span>
			</p>
		</s:iterator>
	</div>
	
	<div class="check_all">
		<a href="/Inception/ShowAll.action">查看所有</a>
	</div>
</div>