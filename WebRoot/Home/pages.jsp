<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div style="margin-left:5px;padding-bottom:100px;">
 <span>总页数:${ pageCount}&nbsp;当前页面:${curPage} 跳转页面</span>
 <s:iterator value="pageList">
 	<a href='<s:property value="href"/>'><s:property value="index"/></a>
 </s:iterator>
 </div>