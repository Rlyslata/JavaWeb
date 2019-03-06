<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>操作界面</title>
<link href="zhujiemian.css"
rel="stylesheet">
<script type="text/javascript">
function showSubMenu(li){
	var submenu=li.getElementsByTagName("ul")[0];
	submenu.style.display="block";
}
function hidesubmenu(li){
	var submenu=li.getElementsByTagName("ul")[0];
	submenu.style.display="none";
}

function changetab(index)
{
	var tabs=document.getElementById("navigation").getElementsByTagName("li");
	var contents=document.getElementById("text").getElementsByTagName("div");
	var t=tabs.length;
	alert(t);
    for(var i=0,len=tabs.length;i<len;i++) {
         if(i==index) {
             tabs[i].className="selected";
             contents[i].style.display="block";
         }else{                        tabs[i].className='';
             contents[i].style.display="none";                    
	}
	 }  
}
</script>
</head>
<body>
  <ul id="navigation" >
   <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)" class=selected><a href="#">员工管理</a>
     <ul>
      <li><a href="javascript:changetab(1);">查询员工信息</a></li>
      <li><a href="javascript:changetab(2);">解雇员工</a></li>
      <li><a href="javascript:changetab(3);">录入新员工</a></li>
      <li><a href="javascript:changetab(4);">更新员工信息</a></li>
      <li><a href="javascript:changetab(5);">查询员工角色</a></li>
      <li><a href="javascript:changetab(6);">添加员工角色</a>
      <li><a href="javascript:changetab(7);">删除员工角色</a></li>
     </ul>
    </li>
    <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)"><a href="#">会员管理</a>
     <ul>
      <li><a href="javascript:changetab(9);">查询会员信息</a></li>
      <li><a href="javascript:changetab(10);">录入新会员</a></li>
      <li><a href="javascript:changetab(11);">更新会员信息</a></li>
     </ul>
    </li>
    <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)"><a href="#">销售管理</a>
     <ul>
      <li><a href="javascript:changetab(13);">查询销售单</a></li>
      <li><a href="javascript:changetab(14);">查询销售明细</a></li>
      <li><a href="javascript:changetab(15);">现金结算</a></li>
      <li><a href="javascript:changetab(16);">积分结算</a></li>
     </ul>
    </li>
    <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)"><a href="#">采购管理</a>
     <ul>
      <li><a href="javascript:changetab(18);">查询采购单</a></li>
      <li><a href="javascript:changetab(19);">查询采购明细</a></li>
      <li><a href="javascript:changetab(20);">录入采购记录</a></li>
      <li><a href="javascript:changetab(21);">录入供货商信息</a></li>
     </ul>
    </li>
    <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)"><a href="#">商品及库存信息管理</a>
     <ul>
      <li><a href="javascript:changetab(23);">查询商品信息</a></li>
      <li><a href="javascript:changetab(24);">下架商品</a></li>
      <li><a href="javascript:changetab(25);">更新商品信息</a></li>
      <li><a href="javascript:changetab(26);">增加新商品</a></li>
     </ul>
    </li>
    <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)"><a href="#">优惠商品管理</a>
     <ul>
      <li><a href="javascript:changetab(28);">查询优惠商品</a></li>
      <li><a href="javascript:changetab(29);">删除优惠商品</a></li>
      <li><a href="javascript:changetab(30);">添加优惠商品</a></li>
     </ul>
    </li>
    <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)"><a href="#">角色管理</a>
     <ul>
      <li><a href="javascript:changetab(32);">删除角色</a></li>
      <li><a href="javascript:changetab(33);">添加角色</a></li>
     </ul>
    </li>
    <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)"><a href="#">积分商品管理</a>
     <ul>
      <li><a href="javascript:changetab(35);">查询积分商品</a></li>
      <li><a href="javascript:changetab(36);">删除积分商品</a></li>
      <li><a href="javascript:changetab(37);">添加积分商品</a></li>
      <li><a href="javascript:changetab(38);">更新积分商品</a></li>
     </ul>
    </li>
    <li
   onmouseover="showSubMenu(this)"
   onmouseout="hidesubmenu(this)"><a href="#">功能管理</a>
     <ul>
      <li><a href="javascript:changetab(40);">查询角色功能</a></li>
      <li><a href="javascript:changetab(41);">添加角色功能</a></li>
      <li><a href="javascript:changetab(42);">删除角色功能</a></li>
     </ul>
    </li>
  </ul>
  <div id="text">
     <div></div>
    <div class="show">
    <h1 align=center>查询员工信息</h1>
    <form action='#' method="post">
                 请输入要查询的员工id:<input type="text" id=shuru name=employeeid/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    <table>
    	<c:forEach items="${requestScope.ygListMap }" var="map">
					<tr>
							<td>${map.EmployeeId }</td>
							<td>${map.EmployeeName }</td>
							<td>${map.AttendDate }</td>
							<td>${map.Birth }</td>
							<td>${map.Salary }</td>
							<td><a href="EditServlet?username=${map.username }&currentUserid=${currentUser.userid}">更改</a></td>
							<td><a href="DeleteServlet?username=${map.username }&currentUserid=${currentUser.userid}">删除</a></td>
					</tr>
					</c:forEach>
	</table>
    </div>
    <div>
    <h1 align=center>删除员工</h1>
    <form action='#' method="post">
                 请输入要删除的员工id:<input type="text" id=shuru name="EmployeeId"/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
     ${FireYgResponseMsg }
    </form>
    </div>
    <div>
    <h1 align=center>录入新员工</h1>
    <form action='' method="post">
                 请输入要录入的员工id:<input type="text" id=shuru name=EmployeeId/>
     请输入要录入的员工密码:<input type="password" id=shuru name=EmployeePassword/>
     请输入员工的入职时间:<input type="text" id=shuru name=AttendDate/>
 请输入员工的出生日期:<input type="text" id=shuru name=Birth/>
 请输入员工的薪水:<input type="text" id=shuru name=Salary/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    ${Yg_idIncorrectExceptionMessage }
    </div>
    <div>
    <h1 align=center>更新员工信息</h1>
    <form action='' method="post">
    请输入要修改的员工id:<input type="text" id=shuru name=EmployeeId/>
     请输入修改后的员工密码:<input type="password" id=shuru name=EmployeePassword/>
 请输入修改后的员工的薪水:<input type="text" id=shuru name=Salary/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    ${UpdateYgResponseMsg }
    </div>
    <div>
    <h1 align=center>查询员工角色</h1>
    <form action='#' method="post">
                 请输入要查询的员工id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>添加员工角色</h1>
    <form action='#' method="post">
                 请输入要添加角色的员工id:<input type="text" id=shuru/>
     请输入要添加的角色id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
     <h1 align=center>删除员工角色</h1>
    <form action='#' method="post">
                 请输入要删除角色的员工id:<input type="text" id=shuru/>
     请输入要删除的角色id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div></div>
    <div>
    <h1 align=center>查询会员信息</h1>
    <form action='' method="post">
    请输入要查询的会员id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>录入新会员</h1>
    <form action='' method="post">
    请输入要录入的会员id:<input type="text" id=shuru/>
 请输入会员名称:<input type="text" id=shuru/>
 请输入会员级别:<input type="text" id=shuru/>
 请输入开通时间:<input type="text" id=shuru/>
 请输入到期时间:<input type="text" id=shuru/>
请输入联系电话:<input type="text" id=shuru/>
请输入办理的员工id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>修改会员信息</h1>
    <form action='' method="post">
    请输入要修改信息的会员id:<input type="text" id=shuru/>
 请输入会员名称:<input type="text" id=shuru/>
 请输入会员级别:<input type="text" id=shuru/>
请输入修改后的联系电话:<input type="text" id=shuru/>
请输入会员的最新积分:<input type="text" id=shuru/>
请输入会员总消费金额：<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div></div>
    <div>
    <h1 align=center>查询销售单</h1>
    <form action='' method="post">
    请输入要查询的销售单号:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>查询销售明细</h1>
    <form action='' method="post">
    请输入要查询的销售单号:<input type="text" id=shuru/>
    请输入要查询的商品号：<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>现金结算</h1>
    <form action='#' method="post">
    请输入结算员工编号:<input type="text" id=shuru/>
 请输入顾客编号:<input type="text" id=shuru/>
 <table border="0" cellpadding="0" cellspacing="1">
 <tr>
 <th>商品id</th>
 <th>商品数量</th>
 </tr>
 <tr>
 <td><input type="text" name="1"></td>
 <td><input type="text" name="2"></td>
 </tr>
 <tr>
 <td><input type="text" name="3"></td>
 <td><input type="text" name="4"></td>
 </tr>
 <tr>
 <td><input type="text" name="5"></td>
 <td><input type="text" name="6"></td>
 </tr>
 <tr>
 <td><input type="text" name="7"></td>
 <td><input type="text" name="8"></td>
 </tr>
 </table>
     <input type="reset" value="重置" class=button>
     <input type="submit" value="提交" class=button>
     </form>
    </div>
    <div>
    <h1 align=center>积分结算</h1>
    <form action='#' method="post">
    请输入结算员工编号:<input type="text" id=shuru/>
 请输入顾客编号:<input type="text" id=shuru/>
  <table border="0" cellpadding="0" cellspacing="1">
 <tr>
 <th>商品id</th>
 <th>商品数量</th>
 </tr>
 <tr>
 <td><input type="text" name="1"></td>
 <td><input type="text" name="2"></td>
 </tr>
 <tr>
 <td><input type="text" name="3"></td>
 <td><input type="text" name="4"></td>
 </tr>
 <tr>
 <td><input type="text" name="5"></td>
 <td><input type="text" name="6"></td>
 </tr>
 <tr>
 <td><input type="text" name="7"></td>
 <td><input type="text" name="8"></td>
 </tr>
 </table>
     <input type="reset" value="重置" class=button>
     <input type="submit" value="提交" class=button>
     </form>
    </div>
    <div></div>
    <div>
    <h1 align=center>查询采购单</h1>
    <form action='#' method="post">
                 请输入要查询的采购单id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>查询采购明细</h1>
    <form action='#' method="post">
                 请输入要查询的采购单号:<input type="text" id=shuru/>
      请输入要查询的商品编号:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>录入采购纪录</h1>
    <form action='#' method="post">
    请输入采购员编号:<input type="text" id=shuru/>
 请输入供应商编号:<input type="text" id=shuru/>
  <table border="0" cellpadding="0" cellspacing="1">
 <tr>
 <th>商品id</th>
 <th>商品数量</th>
 </tr>
 <tr>
 <td><input type="text" name="1"></td>
 <td><input type="text" name="2"></td>
 </tr>
 <tr>
 <td><input type="text" name="3"></td>
 <td><input type="text" name="4"></td>
 </tr>
 <tr>
 <td><input type="text" name="5"></td>
 <td><input type="text" name="6"></td>
 </tr>
 <tr>
 <td><input type="text" name="7"></td>
 <td><input type="text" name="8"></td>
 </tr>
 </table>
     <input type="reset" value="重置" class=button>
     <input type="submit" value="提交" class=button>
     </form>
    </div>
    <div>
    <h1 align=center>录入供货商信息</h1>
    <form action='#' method="post">
 请输入供应商名称:<input type="text" id=shuru/>
 请输入供应商联系方式:<input type="text" id=shuru/>
请输入供应商地址:<input type="text" id=shuru/>
     <input type="reset" value="重置" class=button>
     <input type="submit" value="提交" class=button>
     </form>
    </div>
    <div></div>
    <div>
    <h1 align=center>查询商品信息</h1>
    <form action='' method="post">
    请输入要查询的商品编号:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>下架商品</h1>
    <form action='' method="post">
    请输入要下架的商品编号:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    
    </div>
    <div>
    <h1 align=center>录入商品信息</h1>
    <form action='#' method="post">
 请输入商品名称:<input type="text" id=shuru/>
 请输入商品规格:<input type="text" id=shuru/>
请输入商品售价:<input type="text" id=shuru/>
请输入商品供应商:<input type="text" id=shuru/>
请输入库存量:<input type="text" id=shuru/>
     <input type="reset" value="重置" class=button>
     <input type="submit" value="提交" class=button>
     </form>
    </div>
    <div></div>
    <div>
    <h1 align=center>查询优惠商品</h1>
    <form action='' method="post">
    请输入要查询的优惠商品编号:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
     <h1 align=center>修改优惠商品信息</h1>
    <form action='' method="post">
    请输入要修改的优惠商品编号:<input type="text" id=shuru/>
      请输入修改后的优惠商品起始日期:<input type="text" id=shuru/>
      请输入修改后得优惠结束日期:<input type="text" id=shuru/>
请输入修改后的全场折扣:<input type="text" id=shuru/>
请输入修改后的一级会员折扣:<input type="text" id=shuru/>
请输入修改后的二级会员折扣:<input type="text" id=shuru/>
请输入修改后的三级会员折扣:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>录入优惠商品信息</h1>
    <form action='#' method="post">
 请输入优惠商品编号:<input type="text" id=shuru/>
 请输入优惠起始日期:<input type="text" id=shuru/>
请输入优惠结束日期:<input type="text" id=shuru/>
请输入全场折扣:<input type="text" id=shuru/>
请输入一级会员折扣:<input type="text" id=shuru/>
请输入二级会员折扣:<input type="text" id=shuru/>
请输入三级会员折扣:<input type="text" id=shuru/>
     <input type="reset" value="重置" class=button>
     <input type="submit" value="提交" class=button>
     </form>
    </div>
    <div></div>
    <div>
     <h1 align=center>删除角色</h1>
    <form action='#' method="post">
                 请输入要删除的角色id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
     <h1 align=center>添加角色</h1>
    <form action='#' method="post">
                 请输入要添加的角色名称:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div></div>
    <div>
    <h1 align=center>查询积分商品</h1>
    <form action='#' method="post">
                 请输入要查询的积分商品编号:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>删除积分商品</h1>
    <form action='#' method="post">
                 请输入要删除的积分商品编号:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>添加积分商品</h1>
    <form action='#' method="post">
                 请输入要添加的商id:<input type="text" id=shuru/>
     请输入兑换积分:<input type="text" id=shuru/>
          <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>修改积分商品</h1>
    <form action='#' method="post">
                 请输入要修改的商品编号:<input type="text" id=shuru/>
     请输入修改后的兑换积分:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div></div>
    <div>
    <h1 align=center>查询角色功能</h1>
    <form action='#' method="post">
                 请输入要查询的角色id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>添加角色功能</h1>
    <form action='#' method="post">
                 请输入要添加功能的角色id:<input type="text" id=shuru/>
     请输入要添加的功能名称:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
    <div>
    <h1 align=center>删除角色</h1>
    <form action='#' method="post">
                 请输入要删除的角色id:<input type="text" id=shuru/>
     <input type="submit" value="提交" class=button>
     <input type="reset" value="重置" class=button>
    </form>
    </div>
  </div>
  
</body>
</html>