<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>用户管理-用户查询</title>
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
			<li>用户查询</li>
		</ul>
	</div>
	<form action="${basePath }system/user/select" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>条件:</label> 
				<select name="condition" class="form-control">
					<option value="userName">姓名</option>
					<option value="userAccount">账号</option>
				</select>
				<input type="text" name="content" value="${result }" class="form-control" placeholder="请输入查询条件" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> 
			<a href="view/system/userinfo/userinfo_add.jsp" class="btn btn-success">
				添加用户
			</a>
		</div>
		<div class="row" style="padding: 15px;">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>用户编号</th>
					<th>用户账号</th>
					<th>用户密码</th>
					<th>用户学号</th>
					<th>用户姓名</th>
					<th>用户年龄</th>
					<th>用户性别</th>
					<th>用户标识</th>
					<td>操作</td>
				</tr>
				<c:forEach items="${list }" var="list">
				<tr>        
					<td>${list.userId}</td>
					<td>${list.userAccount }</td>
					<td>${list.userPw }</td>
					<td>${list.userNumber }</td>
					<td>${list.userName }</td>
					<td>${list.userAge }</td>
					<td>${list.userSex }</td>
					<td>${list.userMark }</td>
					<td>
						<a class="btn btn-warning btn-sm" href="system/userinfo/update?userId=${list.userId}">修改</a> 
						<a class="btn btn-danger btn-sm" href="system/userinfo/delete?userId=${list.userId}">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>