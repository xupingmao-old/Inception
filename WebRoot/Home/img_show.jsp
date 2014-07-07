<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="show_div">
	<div class="fold_img_div">
		<img src="/Inception/Home/images/5306c84e70a72.jpg">
	</div>
	<div class="fold_img_div">
		<img src="/Inception/Home/images/5326d5867874d.jpg">
	</div>
	<div class="fold_img_div">
		<img src="/Inception/Home/images/532038aaa9602.jpg">
	</div>
	<div class="show_img_div">
		<img src="/Inception/Home/images/53144d2392623.jpg">
	</div>
</div>
<script>
$(function(){
	$('.show_div').css({'margin-left':($('body').width() - 960) / 2});
	$('.fold_img_div').width(100);
	var speed = 400;
	function img_event(){
		if( $(this).width() > 400){
			return;
		}
		$('.fold_img_div').unbind();
		$('.show_img_div').animate({width:'100px'},speed).removeClass('show_img_div').addClass('fold_img_div');
		$(this).animate({width:'660px'},speed).removeClass('fold_img_div').addClass('show_img_div');
		setTimeout(registEvents, speed);
	}
	function registEvents(){
		$('.fold_img_div').unbind();
		$('.fold_img_div').bind('click', img_event);
		$('.fold_img_div').bind('mouseenter', img_event);
		$('.fold_img_div').bind('mousemove',img_event);
	}
	registEvents();
})
</script>
