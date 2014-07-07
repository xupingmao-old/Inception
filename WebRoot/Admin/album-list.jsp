<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
  <head>
    <title>后台管理</title>
    
    	<jsp:include page="head.jsp"/>
  </head>
  <body>
    <jsp:include page="menu.jsp"/>
      <div class="middle">
      		    <div id="tb">
		        <a href="/Inception/AddAlbum.action" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" id='add' > 添加</a>
		        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" id='del' onclick="delAl()"> 删除 </a>
		    </div>
      <table id="dg" class="easyui-datagrid" >  

		    <thead>  
		        <tr>  
		        	<th data-options="field:'_id_',checkbox:true"></th>
		        	<th data-options="field:'id'">编号</th>
		            <th data-options="field:'name',width:200">名称</th>  
		            <th data-options="field:'description',width:100">演唱者</th>  
		            <th data-options="field:'create_time',width:150">添加时间</th>  
		            <th data-options="field:'publish_date',width:150">出版时间</th>    
		            <th data-options="field:'update',width:300">修改操作</th>      
		        </tr>  
		    </thead>  
		    <tbody>
		    	<s:iterator value="list">
			        <tr>
			        	<td></td>
			        	<td><s:property value="id"/></td>
			        	<td>
			        		<s:property value="albumName"/>
			        	</td>
			        	<td><s:property value="artistName"/></td>
			        	<td><s:property value="uploadDate"/></td>
			        	<td><s:property value="publishDate"/></td>
			        	<td>
			        		<a href='/Inception/UpdateAlbum.action?aid=<s:property value="id"/>'>更新</a>
			        	</td>
			        </tr>
		        </s:iterator>
		    </tbody>
		</table> 
		     <jsp:include page="pages.jsp"></jsp:include>
      </div>
	<s:form id="form1">
		<s:textfield name="operation" id="operation" cssStyle="display:none;"/>
		<s:textfield name="alList" id="alList" cssStyle="display:none;"></s:textfield>
	</s:form>
<script>
$(function(){
	$("#add").click(function (){
		window.location.href="/Inception/AddAlbum.action";
	});
});

function delAl(){
	var obj = $("#dg").datagrid("getChecked");
  	var tar = [];
  	var list = [];
  	for( var i = 0; i < obj.length; i++){
  		tar.push(obj[i].id);
  		list.push(obj[i].name.trim());
  	}
  	$("#alList").val(tar);
  	$("#operation").val("delete");
  	var ac = location.href;
  	var conf = confirm("确定删除" + list + "吗？");
  	if( conf)
  	{
  		$("#form1").submit();
  	}
}
</script>
      <div class="footer">
        <span class="introduce">@2014 XuPingmao Group, all rights reserved</span>
      </div>
  </body>
</html>
