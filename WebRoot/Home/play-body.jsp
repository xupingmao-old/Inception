<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="play_div">
	<audio id = "au" type="audio/mpeg" src="/Inception/files/${m.musicUrl}">
	</audio>
	<div style="overflow:hidden">
		<div class="music-list">
		<div class='music-list-main'>
			<s:iterator value="list"> 
				<div class='list-item'>
					<div class="player_play_icon">
						<img src='/Inception/ImageServlet?url=<s:property value="imageUrl"/>'/>
					</div>
					<span class='list-item-name'>
						<a href='/Inception/Play.action?url=<s:property value="musicUrl"/>'>
							<s:property value="musicName"/>
						</a>
					</span>
					<br/>
				</div>
			</s:iterator>
		</div>
		<a href="/Inception/ClearPlayList.action" >清空播放列表</a>
		</div>
		<div class="lyrics_div">
        	<div id="lrc"></div>
        	<s:if test = "lrc == null || lrc == ''">
        	<span class='upload-lrc'>
        		<span> 此歌曲暂无歌词 </span>
        		<br/>
        		<a href="/Inception/UpdateMusicLyrics.action?mid=${m.id}">更新歌词</a>
        	</span>
        	</s:if>
		</div>
	</div>
	<div class="m-info">
		<H1 class="m-title">${m.musicName }</H1>
		<div class='m-pic'>
			<img src="/Inception/ImageServlet?url=${m.imageUrl }"/>
			<a href="UpdateMusicImage.action?mid=${m.id}">更新图片</a>
		</div>
		<div class='m-right'>
			<div class='m-bas-info'>
				<table>
					<tr><td>演唱者</td><td>${m.artistName }</td></tr>
					<tr><td>出版时间</td><td>${m.publishDate }</td></tr>
					<tr><td>所属专辑</td><td>${m.albumName }</td></tr>
				</table>
			</div>
			<s:if test = "user != null ">
				<s:if test = " prefer == false" >
				<div class="prefer-icon" >
					<img id="prefer-img" src="/Inception/Home/images/unpre.png" onclick="prefer()"/>
					<span id="prefer-result"></span>
				</div>
				</s:if>
				<s:else>
				<div class="prefer-icon" onclick="unprefer()">
					<img id="prefer-img" src="/Inception/Home/images/pre.png"/>
					<span id="prefer-result"></span>
				</div>
				
				</s:else>
			</s:if>
		</div>

	</div>
</div>
<input id='cur-music-url' value="/Inception/Play.action?url=${m.musicUrl }" style="display:hidden"/>
<div class="control_container">
	<div class="control">
		<div class="btns">
			<a href="javascript:void" onclick="play_prev()" hidefocus="true" data-action="prev" class="prv" title="上一首(ctrl+←)">上一首</a>
			<a href="javascript:void" hidefocus="true" data-action="play" class="ply" title="播放/暂停(p)">播放/暂停</a>
			<a href="javascript:void" onclick='play_next()' hidefocus="true" data-action="next" class="nxt" title="下一首(ctrl+→)">下一首</a>
		</div>
		
		<div class="play">
			<div class="mbar" id="mbar">
				<div class="progress" id="progress"></div>
				<div class="progress_icon"></div>
			</div>
		</div>
		
		<div class="info">
			<span id="played">0:0</span><span>&nbsp;/&nbsp;</span><span id="duration"></span>
		</div>
		<div class="volume" id="volumeWrap">
             <a class="mute"  title="静音"></a>
             <div class="vol-slider-wrapper">
	             <div id="volSlider" class="vol-slider">
		             <div class="ui-slider-range" id='ui-slider-range'>
		             </div>
		             <a class="ui-slider-handle" ></a>
	             </div>
             </div>
         </div>
		
		<div id="lrc-hidden" style="display:none">${lrc }</div>
	</div>
</div>

<script src="/Inception/Home/js/play.js"></script>
<script src="/Inception/Home/js/prefer.js"></script>