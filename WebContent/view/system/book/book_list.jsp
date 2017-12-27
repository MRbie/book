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
	<form action="${basePath }system/book/select" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>条件:</label> 
				<select name="condition" class="form-control">
					<option value="bookName">图书名称</option>
					<option value="bookAuthor">图书作者</option>
				</select>
				<input type="text" name="content" value="${result }" class="form-control" placeholder="请输入查询条件" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> 
			<a href="view/system/book/book_add.jsp" class="btn btn-success">
				添加图书
			</a>
		</div>
		<div class="row" style="padding: 15px;">
			<table class="table table-hover table-striped table-bordered">
				<!-- 图书名称 图书作者 图书价格 图书类型 图书出版社 图书总数 -->
				<tr>
					<th>图书编号</th>
					<th>图书名称</th>
					<th>图书作者</th>
					<th>图书价格</th>
					<th>图书类型</th>
					<th>图书出版社</th>
					<th>图书总数</th>
					<th>图书标识</th>
					<th>图书操作</th>
					<td>操作</td>
				</tr>
				<!-- bookId bookName bookAuthor bookPrice bookType bookPublish bookSum bookMark -->
				<c:forEach items="${list }" var="list">
				<tr>        
					<td>${list.bookId}</td>
					<td>${list.bookName }</td>
					<td>${list.bookAuthor }</td>
					<td>${list.bookPrice }</td>
					<td>${list.bookType }</td>
					<td>${list.bookPublish }</td>
					<td>${list.bookSum }</td>
					<td>${list.bookMark }</td>
					<td>
						<a class="btn btn-warning btn-sm" href="system/book/borrow?bookId=${list.bookId}">借书</a> 
						<a class="btn btn-danger btn-sm" href="system/book/repay?bookId=${list.bookId}">还书</a>
					</td>
					<td>
						<a class="btn btn-warning btn-sm" href="system/book/update?bookId=${list.bookId}">修改</a> 
						<a class="btn btn-danger btn-sm" href="system/book/delete?bookId=${list.bookId}">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>