<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="/book_ManagerSystem/img/timg.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p><security:authentication property="principal.username"></security:authentication></p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="/book_ManagerSystem/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>图书管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="/book_ManagerSystem/books/findAll?page=1&size=3"> <i
								class="fa fa-circle-o"></i> 图书管理
						</a></li>
					<li id="system-setting">
						<security:authorize access="hasRole('Manager')"><a
						href="/book_ManagerSystem/users/findAll"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></security:authorize></li>
					<li id="system-setting">
						<security:authorize access="hasRole('Manager')"><a
						href="/book_ManagerSystem/roles/findAll">
							<i class="fa fa-circle-o"></i> 角色管理
					</a></security:authorize></li>
					<li id="system-setting"><security:authorize access="hasRole('Manager')"><a
						href="/book_ManagerSystem/syslog/findAll"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a></security:authorize></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>个人数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="/book_ManagerSystem/books/findMyBookAll?page=1&size=3">
							<i class="fa fa-circle-o"></i> 我的借阅
					</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>