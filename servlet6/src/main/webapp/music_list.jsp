<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<style>
			.content{
				margin-top: 20px;
			}
			.table{
				font-size: 10px;
			}
		</style>
		<script src="./js/xhr.js"></script>
		<script src="./js/list.js"></script>
		
	</head>
	<body>
		
		<!-- 路径导航 -->
		<ol class="breadcrumb">
		  <li><a href="">音乐列表</a></li>
		</ol>
		<!-- 按钮组 -->
	    <div class="btn-group" role="group">
		  <button type="button" class="btn btn-primary btn-sm">
		  	<span class="glyphicon glyphicon-cloud-upload"></span>
		  	音乐上传
		  </button>
		  <button type="button" class="btn btn-danger btn-sm">
		  	<span class="glyphicon glyphicon-trash"></span>
		  	批量删除
		  </button>
		</div>
		<!-- 面板  -->
		<div class="panel panel-primary content">
		  <div class="panel-heading">
		  	<span class="glyphicon glyphicon-list"></span>
		  	音乐列表
		  </div>
		  
		  <div class="panel-body">  	
			<!-- 列表表格 -->
			<table class="table table-bordered table-hover table-striped table-condensed text-center">
				<tr>
					<td>
						<input type="checkbox" />
					</td>
					<td>序号</td>
					<td>歌曲名</td>
					<td>歌手</td>
					<td>专辑</td>
					<td>风格</td>
					<td>路径</td>
					<td>大小</td>
					<td>上传时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${songs}" var="song" varStatus="v">


				<tr>
					<td>
						<input type="checkbox" />
					</td>
					<td>${v.index+1}</td>
					<td>${song.name}</td>
					<td>${song.singer}</td>
					<td>${song.album}</td>
					<td>${song.style}</td>
					<td>${song.location}</td>
					<td>${song.size}</td>
					<td>${song.uploadTime}</td>
					<td>
						<button class="btn btn-primary btn-xs"
								onclick="mydetails(${song.id})">
							<span class="glyphicon glyphicon-info-sign"></span>
							详情
						</button>
						<button class="btn btn-success btn-xs"
								onclick="mydownload('${song.name}','${song.singer}')">
							<span class="glyphicon glyphicon-save"></span>
							下载
						</button>
						<button class="btn btn-danger btn-xs" onclick="myDelete(${u.id},${song.id},this)">
							<span class="glyphicon glyphicon-trash"></span>
							删除
						</button>
					</td>
				</tr>
				</c:forEach>
			</table>
		  </div>
		</div>
	</body>
</html>
