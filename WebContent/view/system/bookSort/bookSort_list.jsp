<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>
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
<title>用户管理-用户类别查询</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>


</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>图书管理</li>
			<li>图书类别查询</li>
		</ul>
	</div>
	<form action="${basePath }system/bookSort/select" method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>条件:</label> 
				<select name="condition" class="form-control">
					<option value="bookSortName">图书类别名称</option>
				</select>
				<input type="text" name="content" value="${result }" class="form-control" placeholder="请输入查询条件" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> 
			<a href="view/system/bookSort/bookSort_add.jsp" class="btn btn-success">
				添加图书类别
			</a>
		</div>
		<div class="row" style="padding: 15px;">
			<%-- <table class="table table-hover table-striped table-bordered">
				<!-- 图书名称 图书作者 图书价格 图书类型 图书出版社 图书总数 -->
				<tr>
					<th>图书类别编号</th>
					<th>图书类别名称</th>
					<th>图书类别标识</th>
					<th>图书类别扩展</th>
					<td>操作</td>
				</tr>
				<!-- //bookSortId bookSortName bookSortExtend bookSortMark -->
				<c:forEach items="${list }" var="list">
				<tr>        
					<td>${list.bookSortId}</td>
					<td>${list.bookSortName }</td>
					<td>${list.bookSortExtend }</td>
					<td>${list.bookSortMark }</td>
					<td>
						<a class="btn btn-warning btn-sm" href="system/bookSort/update?bookSortId=${list.bookSortId}">修改</a> 
						<a class="btn btn-danger btn-sm" href="system/bookSort/delete?bookSortId=${list.bookSortId}">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table> --%>
			
			
			<d:table name="${list }" pagesize="5" requestURI="system/bookSort/select" class="table table-hover table-condensed table-bordered">
				<d:column property="bookSortId" title="图书类别编号"></d:column>
				<d:column property="bookSortName" title="图书类别名称"></d:column>
				<d:column property="bookSortMark" title="图书类别标识"></d:column>
				<d:column property="bookSortExtend" title="图书类别扩展"></d:column>
				
				<%-- <d:column href="" paramId="userId" paramProperty="userId" title="详情" value="详情"></d:column>
				 --%>
				<d:column href="system/bookSort/update" paramId="bookSortId" paramProperty="bookSortId" title="修改" value="修改"></d:column>
				<d:column href="system/bookSort/delete" paramId="bookSortId" paramProperty="bookSortId" title="删除" value="删除"></d:column>
			</d:table>
		</div>
	</form>
</body>
</html>