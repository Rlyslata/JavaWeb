<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adduser.jsp</title>
</head>
<body> 
<h3>权限管理系统</h3>
		<hr/>
<center><b>完善信息添加用户</b></center>
<form action="AddServlet" method="post">
		<table align="center">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value=${signupuser.username }></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value=${signupuser.password }></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="confirmpsd" value=${confirmpsd }></td>
			</tr>
			<tr>
				<td>qq</td>
				<td><input type="text" name="qq" value=${signupuser.qq }></td>
			</tr>
			<tr>
				<td>wechat</td>
				<td><input type="text" name="wechat" value=${signupuser.wechat }></td>
			</tr>
			<tr>
				<td>身份证</td>
				<td><input type="text" name="identitycard" value=${signupuser.identitycard }></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="telephone" value=${signupuser.telephone }></td>
			</tr>
			<tr>
				<td>联系地址</td>
				<td><input type="text" name="address" value=${signupuser.address }></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="添加"></td>
			</tr>
		</table>
	</form>
<center><h5>${usernameRepeatedmsg }${passwordNotmatchmsg }${Nullnameorpassword }</h5></center>
</body>
</html>