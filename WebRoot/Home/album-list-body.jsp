<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="album-list">
	<h2>所有专辑</h2>
	<ul class="album-items">
	<s:iterator value="list">
		<li class="album-item">
			<div class="album-cover">
				<img src='/Inception/AlbumImageServlet?url=<s:property value="imageUrl"/>'/>
			</div>
			<p><a href='/Inception/PlayAlbum.action?album=<s:property value="encodeName"/>'>
				<s:property value="albumName"/></a></p>
		</li>	
	</s:iterator>
	</ul>
	<jsp:include page="pages.jsp"></jsp:include>
</div>


<script>
setMenu(2);
</script>