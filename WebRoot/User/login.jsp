<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>��½</title>
		<link rel="stylesheet" type="text/css" href="css/denglu.css"/>
		</head>
	<body>
		<div class="wapper">
			<div class="header">
				<a href class="logo"></a>
			</div>
			<div class="middle">
				<div class="content">
					<div class="logintitle">   
					<h1>�˺ŵ�½</h1>
					</div>
					<div class="main">
						<s:form action="/Login.action">
							<div class="item">
								<label class="input_email"></label>
								<s:textfield id="email" name="email" type="text" cssClass="basic-input" 
	                                maxlength="60" placeholder="����" tabindex="1" />
							</div>
							<div class="item">
								<label class="input_password"></label>
								<s:textfield id="password" name="passwd" type="password" cssClass="basic-input" 
	                                maxlength="20" tabindex="2" placeholder="����"/>
							</div>
							<div class="item">
								<p class="remember">
						            <input type="checkbox" id="AutoLogin" name="form_autologin" tabindex="4"/>
						            <label>�Զ���¼</label><a class="fogetpassword" href="">��������</a>
						        </p>
							</div>
							<div class="item">
	        					<s:submit value="��½" name="user_login" cssClass="btn-submit" tabindex="5"/>
	        					<a href="regist.jsp">
	        						<input type="button" value="ע��" name="user_register" class="btn-register" tabindex="6"/>
	        					</a>
	        				</div>
						</s:form>
						<div class="otherway-login">
							<span class="intro">����ʹ�����·�ʽ��½</span>
								<div class="item">
									<a class="QQ-login" href="#" title="QQ"></a>
									<a class="weibo-login" href="#" title="΢��"></a>
									<a class="renren-login" href="#" title="������"></a>
								</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer">
				<span class="introduce">@2014 XuPingmao Group, all rights reserved</span>
			</div>
		</div>
	</body>
</html>