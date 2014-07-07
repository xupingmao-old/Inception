<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="p" class="easyui-panel" 
      style="height:470px;background:white;"
      data-options="iconCls:'icon-save',closable:false,
              collapsible:false,minimizable:false,maximizable:false">
          <s:form method="POST" id="form1">
            <s:textfield id="operation" name="operation" cssStyle="display:none"></s:textfield>
            <s:textfield id="userList" name="userList" cssStyle="display:none"></s:textfield>
          <div class="main-top">
              <div class="main-middle-top1">
              <form id="find-user"class="find" method="post">
                <input name="textfield" type="text" size="30" maxlength="30" class="form-text" placeholder="输入邮箱或用户名"/>
                <select id="aa">
                  <option value="1">按邮箱查询</option>
                  <option value="2">按用户名查询</option>
                </select>
                <input type="submit" value="查询" name="find" class="form-find"/>
              </form>
              </div>
              
              <div class="main-middle-top2">
                <span id="btn" href="" onclick="del()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</span>
                <a id="btn" href="#" onclick="to_normal()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">权限改为普通用户</a>
                <a id="btn" href="#"  class="easyui-linkbutton" data-options="iconCls:'icon-edit'">权限改为小管理员</a>
              </div>
              <div class="main-middle-top3">
              <table class="easyui-datagrid" data-option="autoRowHeight:true;ctrlSelect:true">
                <thead>
                    <tr>
                        <th data-options="field:'choose',width:50,checkbox:true">批量操作</th>
                        <th data-options="field:'id',width:50">编号</th>
                        <th data-options="field:'name',width:100">用户名</th>
                        <th data-options="field:'email',width:200">邮箱</th>
                        <th data-options="field:'permission',width:100">权限</th>
                        <th data-options="field:'sex',width:50">性别</th>
                       <!--  <th data-options="field:'change',width:40">修改</th> -->
                    </tr>
                </thead>
                <tbody>
               	<s:iterator value="list">
                    <tr>
                    	<td></td>
                         <td><s:property value="id"/></td> 
                         <td><s:property value="userName"/></td>
                         <td><s:property value="email"/></td>
                         <td><s:property value="sPermission"/></td>
                         <td><s:property value="sSex"/></td>
                        <!--  <td><a id="btn_change" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'"></a></td> -->
                    </tr>
                </s:iterator>
                </tbody>
              </table>
            </div>
            <div class="main-middle-top4" style="margin-left:5px;">
              <!-- <input name="chooseall_checkbox" type="checkbox" value=""/>
              <span>全选</span>
              <input name="chooseopposite_checkbox" type="checkbox" value=""/>
              <span>反选</span>
              -->
            </div>
            <div class="main-middle-top5" style="margin-left:5px;">
				<jsp:include page="pages.jsp"></jsp:include>
            </div>
            </s:form>
          </div>
  
  <script>
  $(function(){
  	$("#operation").val("");
  	$("#userList").val("");
  })
  function del(){
  	var obj = $(".easyui-datagrid").datagrid("getChecked");
  	var tar = [];
  	var list = [];
  	for( var i = 0; i < obj.length; i++){
  		tar.push(obj[i].id);
  		list.push(obj[i].name.trim());
  		if( obj[i].permission == '管理员'){
  			alert("不能删除管理员");
  			return;
  		}
  	}
  	
  	$("#operation").val("delete");
  	$("#userList").val(tar);
  	//alert($("#operation").val());
  	$("#form1").attr("action", location.href);
  	var conf = confirm("确定删除"+list+"吗?");
  	if( conf) {
  	$("#form1").submit();
  	}
  }
  
  function to_super(){
  	var obj = $(".easyui-datagrid").datagrid("getChecked");
  	var tar = [];
  	for( var i = 0; i < obj.length; i++){
  		tar.push(obj[i].id);
  	}
  	$("#userList").val(tar);
  	$("#operation").val("permission_to_super");
  	$("#form1").attr("action", location.href);
  	$("#form1").submit();
  }
  
  function to_normal()
  {
  var obj = $(".easyui-datagrid").datagrid("getChecked");
  	var tar = [];
  	for( var i = 0; i < obj.length; i++){
  		tar.push(obj[i].id);
  	}
  	$("#userList").val(tar);
  	$("#operation").val("permission_to_normal");
  	$("#form1").attr("action", location.href);
  	$("#form1").submit();
  }
  </script>