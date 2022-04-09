<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
		<script type="text/javascript" src="./js/main.js">

		
		</script>
		<script src="./js/list.js"></script>
		<style>
			*{
				border-radius: 0px !important;
			}
			#logo,#title{
				float: left;
			}
			#title{
				margin-top: 10px;
				margin-left: 10px;
				letter-spacing: 5px;
			}
			/*#logo{
				border-radius: 50% !important ;
			}*/
			#content{
				min-height: 500px;
			}
			#iframe{
				position: absolute;
				top: 0;
				bottom: 0;
				border: 0px;
				width: 100%;
				height: 100%;
				padding-right: 20px;
			}
		</style>
	</head>
	<body>
		<!-- 导航条 -->
		<div class="navbar navbar-inverse">
			<div class="container-fluid">
			    <div class="navbar-header">
			        <img class="navbar-brand" alt="Brand" src="img/logo.png">
			      	<a href="" class="navbar-brand">软帝云音乐后台管理</a>
			      
			    </div>
			    <ul class="nav navbar-nav navbar-right">
			    	<li class="dropdown">
			    		<a href="" class="dropdown-toggle" data-toggle="dropdown" >
							${u.username}&nbsp;<span class="caret"></span></a>
			    		<ul class="dropdown-menu">
			    			<li>
			    				<a href="">
				    				<span class="glyphicon glyphicon-user"></span>
				    				个人信息
			    				</a>
			    			</li>
			    			 <li role="separator" class="divider"></li>
			    			<li>
			    				<a href="logout">
			    					<span class="glyphicon glyphicon-log-out"></span>
			    					安全退出
			    				</a>
			    			</li>
			    		</ul>
			    	</li>
			    </ul>
			</div>
		</div>
		<!-- 菜单和内容区域 -->
		<div class="container-fluid">
			<!-- 菜单 -->
			<div class="col-md-2 col-sm-2 col-xs-5" id="menu">
				<div class="list-group">
				  <a href="add_music.html" class="list-group-item active" target="page"><span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;音乐上传</a>
				  <a href="music_list.jsp" class="list-group-item" target="page"><span class="glyphicon glyphicon-list"></span>&nbsp;音乐列表</a>
				  <a onclick="f1(this)" href="#" class="list-group-item"><span class="glyphicon glyphicon-user"></span>&nbsp;用户管理</a>
				  <a href="repassword.jsp" class="list-group-item"><span class="glyphicon glyphicon-pencil"></span>&nbsp;修改密码</a>
				  <a href="logout" class="list-group-item"><span class="glyphicon glyphicon-log-out"></span>&nbsp;系统退出</a>
				
				</div>
				
			</div>
			<!-- 内容 -->
			<div class="col-md-10 col-sm-10 col-xs-7" id="content">
				<iframe id="iframe" name="page" src="add_music.html"></iframe>
			</div>
			
			<!-- 版权区 -->
			<p class="text-center">&copy;软帝集团 By Mr.Zhou</p>
		</div>
	</body>
</html>
