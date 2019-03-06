<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginPage</title>
</head>
<body>
	<div id="01">
		<h3>权限管理系统</h3>
		<hr/>
		<center><h4>输入用户名和密码登录</h4></center>
		<div id="02" align="center">
			<form action="LoginServlet" method="get">
				<table >
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" value="${loginname }" style="width:150px;"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="password" value="${loginpassword }" style="width:150px;"></td>
				</tr>
				<tr>
						<td><input type="submit" value="登录"></td>
						<td><a href="register.jsp">点击这里去注册</a></td>
				</tr>
				</table>
			</form>
		<center><h5>${nameErrormsg}</h5></center><center><h5>${psdErrormsg}</h5></center>
		</div>
	</div>

</body>
</html>