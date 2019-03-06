<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="EditUserServlet?EditedUserid=${EditedUser.userid }" method="post">
		<table align="center">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value=${EditedUser.username }></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value=${EditedUser.password }></td>
			</tr>
			<tr>
				<td>qq</td>
				<td><input type="text" name="qq" value=${EditedUser.qq }></td>
			</tr>
			<tr>
				<td>wechat</td>
				<td><input type="text" name="wechat" value=${EditedUser.wechat }></td>
			</tr>
			<tr>
				<td>身份证</td>
				<td><input type="text" name="identitycard" value=${EditedUser.identitycard }></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="telephone" value=${EditedUser.telephone }></td>
			</tr>
			<tr>
				<td>联系地址</td>
				<td><input type="text" name="address" value=${EditedUser.address }></td>
			</tr>
			<c:if test="${currentUser.userid==0 }" var="Issupermanager" scope="request">
				<tr>
					<td>授予角色：</td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${useridIsGeneral=='Yes'}">
							<td><input type="checkbox" name="role" value="general" checked="checked">general</td>
						</c:when>
						<c:otherwise>
							<td><input type="checkbox" name="role" value="general" >general</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${useridIsManager=='Yes'}">
							<td><input type="checkbox" name="role" value="manager" checked="checked">manager</td>
						</c:when>
						<c:otherwise>
							<td><input type="checkbox" name="role" value="manager" >manager</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:if>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="确认更改"></td>
			</tr>
		</table>
	</form>
<!-- 异常信息显示 -->
<center><h5>${usernameRepeatedmsg }${passwordNotmatchmsg }${Nullnameorpassword }</h5></center>
<%-- <c:if test="${useridIsGeneral=='Yes' }"> --%>
<%-- <c:out value="useridIsGeneral==${useridIsGeneral }"></c:out> --%>
<%-- </c:if> --%>
<%-- <c:out value="${useridIsManager }"></c:out> --%>
</body>
</html>