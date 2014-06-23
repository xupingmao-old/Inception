<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>注册</title>
		<link rel="stylesheet" type="text/css" href="css/zhuce.css"/>
		</head>
	<body>
		<div class="wapper">
				<div class="header">
					<a href class="logo"></a>
					<div class="log-in-remind">
						<span>我已是会员</span>
						<a href="" class="log-in" >立即登录</a>
					</div>
				</div>
				<div class="middle">
					<div class="rightcontent">
						<div class="main">
							<h1>用户注册</h1>
							<s:form id="lzform" name="lzform" method="post" action="UserRegist.action">
								<div class="regform-item regform-item-first">
									<label>邮箱</label>
									<s:textfield id="email" name="email" type="text" cssClass="basic-input" maxlength="60" tabindex="1" placeholder="邮箱"/>
								</div>
								<div class="regform-item regform-item-second">
									<label>密码</label>
									<s:textfield id="password" name="passwd" type="password" cssClass="basic-input" maxlength="60" tabindex="2" placeholder="密码"/>
								</div>
								<div class="regform-item regform-item-third">
									<label>确认密码</label>
									<s:textfield id="passwordagain" name="passwd2" type="password" cssClass="basic-input" maxlength="60" tabindex="3" placeholder="确认密码"/>
								</div>
								<div class="regform-item regform-item-fourth">
									<s:submit value="注册" name="user_login" cssClass="btn-submit" tabindex="4"/>
								</div>
							</s:form>
						</div>
					</div>
				</div>
				<div class="footer">
				<span class="introduce">@2014 XuPingmao Group, all rights reserved</span>
				</div>
		</div>
	</body>
</html>