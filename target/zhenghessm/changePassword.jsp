<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>图书管理系统</title>

<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="/book_ManagerSystem/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/book_ManagerSystem/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/book_ManagerSystem/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="/book_ManagerSystem/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="/book_ManagerSystem/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="all-admin-index.html"><b>图书管理系统</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">密码修改</p>

			<form action="/book_ManagerSystem/users/changePassword" method="post">
				<div class="form-group has-feedback">
					<input type="text" name="username" class="form-control"
						placeholder="用户名"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control"
						placeholder="旧密码"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="newPassword" class="form-control"
						   placeholder="新密码"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">

					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">确认修改</button>
					</div>
					<!-- /.col -->
				</div>
			</form>




		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<!-- Bootstrap 3.3.6 -->
	<!-- iCheck -->
	<script
		src="/book_ManagerSystem/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="/book_ManagerSystem/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="/book_ManagerSystem/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>

</html>