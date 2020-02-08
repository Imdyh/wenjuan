<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>后台管理中心</title>
		<link rel="shortcut icon" href="img/favicon.ico"/>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/manager/console.css" />

		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	</head>

	<body>
		<div class='head'>
			<span class="tit">我的后台管理</span>
			<span class='admininfo' >
			
			<c:if test="${logintype eq 'qq'}">
			<span>
			<c:if test="${user.role==1}"><span style="color:red;">管理员 </span></c:if> 
			<c:if test="${user.role==0}"><span>用户 </span></c:if>${user.qqUser.nickname}
			</span>
			<a href="javascript:;" data-toggle="collapse" data-target="#mineinfo">
				<img id="qlogo" src="${user.qqUser.figureurl_1}" alt="加载头像失败"  class="img-circle">
			</a>
			</c:if>
			
			<c:if test="${logintype eq 'email'}">
			<span>
			<c:if test="${user.role==1}"><span style="color:red;">管理员 </span></c:if> 
			<c:if test="${user.role==0}"><span>用户 </span></c:if>${user.nickname}
			</span>
			<a href="javascript:;" data-toggle="collapse" data-target="#mineinfo">
				<img id="qlogo" src="${user.headicon}" alt="加载头像失败"  class="img-circle">
			</a>
			</c:if>
			
			<div id="mineinfo" class="collapse list-group">
				<a href="javascript:;" style="border-radius: 0px;" class="list-group-item">
					<h4 class="list-group-item-heading" style="margin-top: 5px">
						<span class="glyphicon glyphicon-user" ></span> 我的账户
					</h4>
				</a>
				<a href="javascript:;" style="border-radius: 0px;" class="list-group-item">
					<h4 class="list-group-item-heading" style="margin-top: 5px">
						<span class="glyphicon glyphicon-lock" ></span> 密码更改
					</h4>
				</a>
				<a id="exit" href="javascript:;" style="border-radius: 0px;text-decoration: none" class="popover-toggle popover-options list-group-item" 
					title="<h4 style='color:red;'>确定退出登录吗？</h4>" data-container="body" data-toggle="popover" data-placement="left"
					data-content="<div style='text-align: center;'><a type='button' href='loginout' class='btn btn-success'>确定</a>&nbsp;&nbsp;&nbsp;<button class='btn btn-danger' onclick='no()' >取消</button></div>">
					<h4 class="list-group-item-heading" style="margin-top: 5px; text-align: center;" >
			     	 退出登录 <span class="glyphicon glyphicon-log-out"></span></h4>
				</a>
			</div>
		</span>
		</div>
		<div class='main'>
			<div class="nav">
				<div class="list-group">
					<a href="javascript:;" style="border-radius: 0px;border-top: 0px;"  class="list-group-item">
						<h4 class="list-group-item-heading" style="margin-top: 5px">
							<span class="glyphicon glyphicon-home"></span> 首页
						</h4>
					</a>
					<a id="wjzx" href="javascript:;" style="border-radius: 0px;" class="list-group-item a" data-toggle="collapse" data-target="#wjzxlist">
						<h4 class="list-group-item-heading" style="margin-top: 5px">
							<span class="glyphicon glyphicon-file"></span>
							问卷中心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-chevron-down small"></span>
						</h4>
					</a>
					<div id="wjzxlist" class="collapse list-group">
						<a href="javascript:;"  class="list-group-item">
							<h4 class="list-group-item-heading" style="margin-top: 5px">
								<span class="glyphicon glyphicon-plus" ></span> 新建问卷
							</h4>
						</a>
						<a href="javascript:;" class="list-group-item">
							<h4 class="list-group-item-heading" style="margin-top: 5px">
								<span class="glyphicon glyphicon-list-alt" ></span> 我的问卷
							</h4>
						</a>
						<a href="javascript:;" style="border-radius: 0px;" class="list-group-item">
							<h4 class="list-group-item-heading" style="margin-top: 5px">
								<span class="glyphicon glyphicon-th"></span> 问卷数据
							</h4>
						</a>
					</div>
					
					<%--管理员start --%>
					<c:if test="${user.role==1}">
					<a href="javascript:;" style="border-radius: 0px;" class="list-group-item">
						<h4 class="list-group-item-heading" style="margin-top: 5px">
							<span class="glyphicon glyphicon-th-large"></span> 模板管理
						</h4>
					</a>
					<a href="javascript:;" style="border-radius: 0px;" class="list-group-item">
						<h4 class="list-group-item-heading" style="margin-top: 5px">
							<span class="glyphicon glyphicon-user"></span> 用户管理
						</h4>
					</a>
					<a href="javascript:;" style="border-radius: 0px;" class="list-group-item">
						<h4 class="list-group-item-heading" style="margin-top: 5px">
							<span class="glyphicon glyphicon-th-list"></span> 数据统计
						</h4>
					</a>
					
					<a href="javascript:;" style="border-radius: 0px;" class="list-group-item a" data-toggle="collapse" data-target="#cptg">
						<h4 class="list-group-item-heading" style="margin-top: 5px">
							<span class="glyphicon glyphicon-send"></span> 
							产品推广&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-chevron-down small"></span>
						</h4>
					</a>
					<div id="cptg" class="collapse list-group">
						<a href="javascript:;"  class="list-group-item" style="border-radius: 0px;">
							<h4 class="list-group-item-heading" style="margin-top: 5px">
								<span class="glyphicon glyphicon-envelope" ></span> 邮件群发
							</h4>
						</a>
						<a href="javascript:;" class="list-group-item" style="border-radius: 0px;">
							<h4 class="list-group-item-heading" style="margin-top: 5px">
								<span class="glyphicon glyphicon-phone" ></span> 短信群发
							</h4>
						</a>
					</div>
					
					<a href="javascript:;" style="border-radius: 0px;" class="list-group-item">
						<h4 class="list-group-item-heading" style="margin-top: 5px">
							<span class="glyphicon glyphicon-comment"></span> 用户留言
						</h4>
					</a>
					
					<a href="javascript:;" style="border-radius: 0px;" class="list-group-item a" data-toggle="collapse" data-target="#xtsh">
						<h4 class="list-group-item-heading" style="margin-top: 5px">
							<span class="glyphicon glyphicon-cog"></span> 
							系统设置&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-chevron-down small"></span>
						</h4>
					</a>
					<div id="xtsh" class="collapse list-group">
						<a href="javascript:;"  class="list-group-item" style="border-radius: 0px;">
							<h4 class="list-group-item-heading" style="margin-top: 5px">
								<span class="glyphicon glyphicon-envelope" ></span> 邮箱更改
							</h4>
						</a>
						<a href="javascript:;" class="list-group-item" style="border-radius: 0px;">
							<h4 class="list-group-item-heading" style="margin-top: 5px">
								<span class="glyphicon glyphicon-volume-up" ></span> 活动公告
							</h4>
						</a>
					</div>
				</div>
				</c:if>
				<%--管理员end --%>
				<%--
				<div style="position: fixed;bottom: 50px;width: 200px;" >
					<hr />
					<a id="exit" href="javascript:;" style="border-radius: 0px;text-decoration: none" class="popover-toggle popover-options"
						title="<h4 style='color:red;'>确定退出登录吗？</h4>" data-container="body" data-toggle="popover" data-placement="top"
						data-content="<div style='text-align: center;'><a type='button' href='/' class='btn btn-success'>确定</a>&nbsp;&nbsp;&nbsp;<button class='btn btn-danger' onclick='no()' >取消</button></div>">
						<h4 class="list-group-item-heading" style="margin-top: 5px; text-align: center;" >
				     	 安全退出 <span class="glyphicon glyphicon-log-out"></span></h4>
					</a>
				</div>
				 --%>
			</div>
			<div class="contex">
				<!--右侧内容-->
			</div>
		</div>

		<!--js文件-->
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/manager/console.js" ></script>
	</body>

</html>