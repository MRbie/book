<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>用户管理-用户修改</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>


<!-- 输入验证 -->
<script src="resource/jquery-validation-1.17.0/lib/jquery.js"></script>
<script src="resource/jquery-validation-1.17.0/dist/jquery.validate.js"></script>
<script src="resource/jquery-validation-1.17.0/dist/localization/messages_zh.js"></script>


<script type="text/javascript">
/* $().ready(function() {
    $("#commentForm").validate();
}); */
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#commentForm").validate({
	    rules: {
	    	userNumber: {
	    		number:true,
	      },
	      userAge: {
	    	  number:true,
	      },
	    },
	    messages: {
			//可以自定义提示信息
	    	}
	    })
	});
</script>

<style>
.error{
	color:red;
}
</style>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>用户修改</li>
		</ul>
	</div>
<form action="system/userinfo/update" id="commentForm" class="form-horizontal" method="post">
		<input type="hidden" name="userId" value="${user.userId }"/>	
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户学号</label>
					<div class="col-xs-9 ">
						<input type="text" required value="${user.userNumber }" name="userNumber" class="form-control" placeholder="请输入用户学号" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户姓名</label>
					<div class="col-xs-9 ">
						<input type="text" required value="${user.userName }" name="userName" class="form-control" placeholder="请输入用户姓名" />
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
						<input type="text" required value="${user.userAge }" name="userAge" class="form-control" placeholder="请输入用户年龄" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户性别</label>
					<div class="col-xs-9 ">
						<select class="form-control" name="userSex">
							<option ${user.userSex=='保密'?'selected':'' }>保密</option>
							<option ${user.userSex=='男'?'selected':'' }>男</option>
							<option ${user.userSex=='女'?'selected':'' }>女</option>
						</select>
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
						<select class="form-control" name="userMark">
							<option ${user.userMark=='管理员'?'selected':'' }>管理员</option>
							<option ${user.userMark=='普通学生'?'selected':'' }>普通学生</option>
						</select>
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
						<input type="text" required value="${user.userAccount }" name="userAccount" class="form-control" placeholder="请输入用户账号" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户密码</label>
					<div class="col-xs-9 ">
						<input type="text" required value="${user.userPw }" name="userPw" class="form-control" placeholder="请输入用户密码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="修改用户" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
			</div>

		</div>
	</form>
</body>
</html>