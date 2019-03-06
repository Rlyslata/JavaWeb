<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 實例化一個 SearchBean对象-->
<c:if test="${empty bean }" scope="session" var="YES">
<c:out value="没有bean开始创建"></c:out>
<jsp:useBean id="bean" class="com.ecust.xgp.domain.SearchBean" scope="session"></jsp:useBean>
<c:set target="${sessionScope.bean }" property="currentPage" value="1"></c:set>
<c:set target="${sessionScope.bean }" property="rawNum" value="5"></c:set>
<c:set target="${sessionScope.bean }" property="field" value=""></c:set>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>homepage</title>
</head>
<body>
<table align="center" width="80%">
<tr>
<td>
<table border="1px" width="100%">
	<tr >
		<td width="60%"><h2>权限管理</h2></td>
		<td width="35%">欢迎<i>${currentUser.username }</i>登录</td>
		<td ><a href="Loginpage.jsp">退出</a>
	</tr>
	<tr>
		<td colspan="3"><hr/></td>
	</tr>
</table>
</td>
</tr>
<tr>
<td>
<table border="1px" width="100%">
	<tr>
		<!-- 當前用戶的信息 -->
		<td width="20%">
		<form action="UpdateServlet">
			<table >
				<tr>
					<td colspan="2">
						<h4 align="center">個人中心</h4>
					</td>
				</tr>
				<tr>
					<td >用戶ID：</td>	
					<td><input type="text" value="${currentUser.userid }" name="userid" readonly="readonly"></td>			
				</tr> 
				<tr>
					<td >用戶名：</td>	
					<td><input type="text" value="${currentUser.username }" name="username"></td>			
				</tr> 
				<tr>
					<td >密码：</td>	
					<td><input type="password" value="${currentUser.password }" name="password"></td>			
				</tr> 
				<tr>	
					<td>QQ:</td>
					<td><input type="text" value="${currentUser.qq }" name="QQ"></td>	
				</tr>
				<tr>
					<td>WeChat:</td>
					<td><input type="text" value="${currentUser.wechat }" name="Wechat"></td>
				</tr>
				<tr>
					<td>identitycard:</td>
					<td><input type="text" value="${currentUser.identitycard }" name="identitycard"></td>
				</tr>
				<tr>
					<td>telephone:</td>
					<td><input type="text" value="${currentUser.telephone }" name="telephone"></td>
				</tr>	
				<tr>
					<td>address:</td>
					<td><input type="text" value="${currentUser.address }" name="address"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="确认更改" > 
					</td>
				</tr>
			</table>
			</form>
			${repeatedusernamemsg }
		</td>
		<!-- 功能區 -->
		<td  >
			<table border="1px" width="100%" bordercolor="red">
				<tr>
					<td colspan="4" width="100%"><center><h4>功能区</h4></center></td>
				</tr>
				<tr>
<!-- 					<td width="100%"> -->
<!-- 					<table width="100%"> -->
<!-- 					<tr> -->
						<td ><a href="AddUserServlet?currentUserid=${currentUser.userid }">添加用户</a></td>
						<!--查询所有用户，无区别查找-->
						<td ><a href="SearchServlet?field=&currentPage=1">查询用户</a></td>								
						<td colspan="2">
							<form action="SearchServlet?currentPage=1" method="post">
								<input type="text" name="field" value=${bean.field }>
								<input type="submit" value="搜索">
							</form>
						</td>
<!-- 					</tr> -->
<!-- 					</table> -->
<!-- 					</td> -->
				</tr>
				<tr>
					<td colspan="4">
					<table border='1' width="100%" align="center">
					<tr>
						<td>用户id</td>
						<td>用户名</td>
						<td>QQ</td>
						<td>wechat</td>
					 	<td>identitycard</td>
						<td>telephone</td>
						<td>address</td>
						<td colspan="2" align='center'>操作</td>
					</tr>
					<c:forEach items="${sessionScope.bean.beanlist}" var="map">
					<tr>
							<td>${map.userid }</td>
							<td>${map.username }</td>
							<td>${map.qq }</td>
							<td>${map.wechat }</td>
							<td>${map.identitycard }</td>
							<td>${map.telephone }</td>
							<td>${map.address }</td>
							<td><a href="EditServlet?username=${map.username }&currentUserid=${currentUser.userid}">更改</a></td>
							<td><a href="DeleteServlet?username=${map.username }&currentUserid=${currentUser.userid}">删除</a></td>
					</tr>
					</c:forEach>
					</table>
					</td>
				</tr>
				<tr>
					<td width="25%">第${bean.currentPage }页/共${bean.maxPage }页</td>
					<td><a href="SearchServlet?currentPage=1&field=${bean.field }">首页</a></td>
					<td><a href="SearchServlet?currentPage=${bean.lastPage }&field=${bean.field }">上一页</a></td>
					<td><a href="SearchServlet?currentPage=${bean.afterPage }&field=${bean.field }">下一页</a>
					<a href="SearchServlet?currentPage=${bean.maxPage }&field=${bean.field }">尾页</a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</td>
</tr>
</table>
<!-- 异常信息显示 -->
<center>${nopowermsg }</center>
</body>
</html>