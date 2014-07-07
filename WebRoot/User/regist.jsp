<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>ע��</title>
		<link rel="stylesheet" type="text/css" href="css/zhuce.css"/>
<style>
.error{
color:red;
}

.error li span
{
color:red;
padding-left:40px;
}
</style>
</head>
	<body>
		<div class="wapper">
				<div class="header">
					<a href="/Inception/Home.action" class="logo"></a>
					<div class="log-in-remind">
						<span>�����ǻ�Ա</span>
						<a href="login.jsp" class="log-in" >������¼</a>
					</div>
				</div>
				<div class="middle">
					<div class="rightcontent">
						<div class="main">
							<h1>�û�ע��</h1>
							<s:form id="lzform" name="lzform" method="post" action="UserRegist.action">
								<s:fielderror cssClass="error" cssStyle="list-style:none;color:red;padding:0px;">
	                                	<s:param>registError</s:param>
	                                </s:fielderror>
								<div class="regform-item regform-item-first">
									<label>����</label>
									<s:textfield id="email" name="email" type="text" cssClass="basic-input" maxlength="60" tabindex="1" placeholder="����"/>
									<s:fielderror cssStyle="list-style:none;color:red;padding:0px;">
	                                	<s:param>emailError</s:param>
	                                </s:fielderror>
								</div>
								<div class="regform-item regform-item-second">
									<label>����</label>
									<s:textfield id="password" name="passwd" type="password" cssClass="basic-input" maxlength="60" tabindex="2" placeholder="����,6-20����ĸ������"/>
									<s:fielderror cssStyle="list-style:none;color:red;padding:0px;">
	                                	<s:param>passwdError</s:param>
	                                </s:fielderror>
								</div>
								<div class="regform-item regform-item-third">
									<label>ȷ������</label>
									<s:textfield id="passwordagain" name="passwd2" type="password" cssClass="basic-input" maxlength="60" tabindex="3" placeholder="ȷ������"/>
									<s:fielderror cssStyle="list-style:none;color:red;padding:0px;">
	                                	<s:param>passwd2Error</s:param>
	                                </s:fielderror>
								</div>
								<div class="regform-item regform-item-fourth">
									<s:submit value="ע��" name="user_login" cssClass="btn-submit" tabindex="4"/>
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