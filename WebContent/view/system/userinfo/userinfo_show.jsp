<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>用户管理-用户添加</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript"
	src="resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>用户添加</li>
		</ul>
	</div>
<form action="" class="form-horizontal">
		<input type="hidden" name="userId" value="${userLogin.userId }"/>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户学号</label>
					<div class="col-xs-9 ">
						<%-- <input type="text" value="${user.userNumber }" name="userNumber" class="form-control" placeholder="请输入用户学号" /> --%>
						<p class="form-control-static">${userLogin.userNumber }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户姓名</label>
					<div class="col-xs-9 ">
						<%-- <input type="text" value="${userLogin.userName }" name="userName" class="form-control" placeholder="请输入用户姓名" /> --%>
						<p class="form-control-static">${userLogin.userName }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户年龄</label>
					<div class="col-xs-9 ">
						<%-- <input type="text" value="${userLogin.userAge }" name="userAge" class="form-control" placeholder="请输入用户年龄" /> --%>
						<p class="form-control-static">${userLogin.userAge }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户性别</label>
					<div class="col-xs-9 ">
						<%-- <select class="form-control" name="userSex">
							<option ${userLogin.userSex=='保密'?'selected':'' }>保密</option>
							<option ${userLogin.userSex=='男'?'selected':'' }>男</option>
							<option ${userLogin.userSex=='女'?'selected':'' }>女</option>
						</select> --%>
						<p class="form-control-static">${userLogin.userSex }</p>
					</div>
				</div>
			</div>

		</div>
		<!--结束2 -->
		
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户标识</label>
					<div class="col-xs-9 ">
						<%-- <select class="form-control" name="userMark">
							<option ${userLogin.userMark=='管理员'?'selected':'' }>管理员</option>
							<option ${userLogin.userMark=='普通学生'?'selected':'' }>普通学生</option>
						</select> --%>
						<p class="form-control-static">${userLogin.userMark }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
				</div>
			</div>
		</div>
		<!--结束3 -->

		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">账号信息</h5>
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户账号</label>
					<div class="col-xs-9">
						<%-- <input type="text" value="${userLogin.userAccount }" name="userAccount" class="form-control" placeholder="请输入用户账号" /> --%>
						<p class="form-control-static">${userLogin.userAccount }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户密码</label>
					<div class="col-xs-9 ">
						<%-- <input type="text" value="${userLogin.userPw }" name="userPw" class="form-control" placeholder="请输入用户密码" /> --%>
						<p class="form-control-static">${userLogin.userPw }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->


	</form>
</body>
</html>