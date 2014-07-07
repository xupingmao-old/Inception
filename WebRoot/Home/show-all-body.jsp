<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="recommend_div">
	<div class="recommend_title">
		<span class="recommend_title_text">所有歌曲</span>
		<a href="#"><span class="span12 padding-lr-10">流行</span></a>
		<a href="#"><span class="span12 padding-lr-10">摇滚 </span></a>
		<a href="#"><span class="span12 padding-lr-10">民谣</span></a>
		<a href="#"><span class="span12 padding-lr-10">电子</span></a>
	</div>
	<div class="recommend_line">
	</div>
	<ul class="recommend_items">
	<s:iterator value="list">
		<li class="recommend_item">
			<div class="recommend_item_cover">
				<img src='/Inception/ImageServlet?url=<s:property value="imageUrl"/>'/>
				<div class="recommend_item_bottom">
					<span class="headset_icon"></span>
					<span><s:property value="CTR"/></span>
						<a href='/Inception/Play.action?url=<s:property value="musicUrl"/>'>
							<span class="play_icon"></span>
						</a>
				</div>
			</div>
			<p><s:property value="musicName"/></p>
		</li>	
	</s:iterator>
	</ul>
	<jsp:include page="pages.jsp"></jsp:include>
</div>


<script>
setMenu(1);
</script>