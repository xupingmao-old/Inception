<%@ page language="java" import = "java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 

<div class="wrapper">
      <div class="header">
        <a class="logo" href="/Inception/Home.action"></a>
        <div class="tbody">
          <table>
          <tr>
            <td>
            <span>当前用户:</span>
            <span class="user">${user.userName}</span>
            <span>权限:</span><span id="user-permission">${user.SPermission}</span>
            <a href="Logout.action" class="exit">退出</a>
            <a href="Home.action">返回主页</a>
            </td>
          </tr>
          </table>
        </div>
      </div>
      <div id="navigation">
        <ul>
          <li class="level1"><a href="/Inception/Home.action">首页</a></li>
          <li class="level1"><a href="AdminMain.action?start=0">用户管理</a>
              <ul class="sub-menu" id="a1">
                <li class="level2"><a href="AdminMain.action?start=0">用户列表</a></li>
                <li class="level2"><a href="AdminMain.action?start=0">权限管理</a></li>
              </ul>
          </li>
          <li class="level1"><a href="/Inception/AdminMusic.action">音乐管理</a>
            <ul class="sub-menu" id="a2">
              <li class="level2"><a href="/Inception/AdminMusic.action">音乐列表</a></li>
              <li class="level2"><a href="/Inception/AdminMusicAdd.action">添加音乐</a></li>

            </ul>
          </li>
          <li class="level1"><a href="/Inception/AdminAlbumList.action">专辑管理</a>
         	 <ul class="sub-menu" id="a2">
          	  <li class="level2"><a href="/Inception/AdminAlbumList.action">专辑列表</a></li>
              <li class="level2"><a href="/Inception/AddAlbum.action">添加专辑</a></li>
              </ul>
          </li>
          <li class="level1"><a href="#">数据统计</a></li>
        </ul>
      </div>
      </div>