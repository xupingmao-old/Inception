<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
  <head>
    <title>��̨����</title>
    
    	<jsp:include page="head.jsp"/>
  </head>
  <body>
    <jsp:include page="menu.jsp"/>
      <div class="middle">
      		    <div id="tb">
		        <a href="/Inception/AdminMusicAdd.action" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" id='add' > ���</a>
		        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" id='delmusic' onclick="delMusic()"> ɾ�� </a>
		    </div>
      <table id="dg" class="easyui-datagrid" >  

		    <thead>  
		        <tr>  
		        	<th data-options="field:'_id_',checkbox:true"></th>
		        	<th data-options="field:'id'">���</th>
		            <th data-options="field:'name',width:200">����</th>  
		            <th data-options="field:'description',width:100">�ݳ���</th>  
		            <th data-options="field:'type',width:100">����</th>
		            <th data-options="field:'language',width:100"/>����</th>
		            <th data-options="field:'create_time',width:150">����ר��</th>      
		            <th data-options="field:'update',width:300">�޸Ĳ���</th>      
		        </tr>  
		    </thead>  
		    <tbody>
		    	<s:iterator value="list">
			        <tr>
			        	<td></td>
			        	<td><s:property value="id"/></td>
			        	<td>
			        	<a href='/Inception/Play.action?url=<s:property value="musicUrl"/>'>
			        		<s:property value="musicName"/></td>
			        	</a>
			        	<td>
			        		<s:property value="artistName"/>
			        	</td>
			        	<td><s:property value="musicStyle"/></td>
			        	<td><s:property value="musicLanguage"/></td>
			        	<td><s:property value="albumName"/></td>
			        	<td>
			        		<a href='/Inception/AdminMusicUpdate.action?mid=<s:property value="id"/>'>����</a>
			        		<a href='/Inception/UpdateMusicImage.action?mid=<s:property value="id"/>'>����ͼƬ</a>
			        		<a href='/Inception/UpdateMusicLyrics.action?mid=<s:property value="id"/>'>���¸��</a>
			        	</td>
			        </tr>
		        </s:iterator>
		    </tbody>
		</table> 
		        <jsp:include page="pages.jsp"></jsp:include>
      </div>
	<s:form id="form1">
		<s:textfield name="operation" id="operation" cssStyle="display:none;"/>
		<s:textfield name="musicList" id="musicList" cssStyle="display:none;"></s:textfield>
	</s:form>
<script>
$(function(){
	$("#add").click(function (){
		window.location.href="/Inception/AdminMusicAdd.action";
	});
});

function delMusic(){
	var obj = $("#dg").datagrid("getChecked");
  	var tar = [];
  	var list = [];
  	for( var i = 0; i < obj.length; i++){
  		tar.push(obj[i].id);
  		list.push($(obj[i].name.trim()).html().trim());
  	}
  	$("#musicList").val(tar);
  	$("#operation").val("delete");
  	var ac = location.href;
  	var conf = confirm("ȷ��ɾ��"+list+"��");
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
