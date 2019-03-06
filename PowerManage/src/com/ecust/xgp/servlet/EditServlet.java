package com.ecust.xgp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecust.xgp.dao.impl.DaoFactory;
import com.ecust.xgp.domain.User;
import com.ecust.xgp.service.PowerCheckService;
import com.ecust.xgp.service.impl.ServiceFactory;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;utf-8");
		/*
		 * userid:被修改用户id
		 * currentuserid：当前进行操作的用户id
		 * 更改操作：对一般用户，需要管理员或超级管理员权限
		 * 对管理员，需要超级管理员权限
		 * 处理方法:
		 * 1.先判断userid是管理员，还是一般用户
		 * 2.userid是一般用户，则检查currentUserid用户是否是管路员或者超级管理员
		 * 3.userid是管理员，则检查currentuserid用户是否是超级管理员
		 * 4.在2,3中有权限则转发至修改update.jsp，没权限则返回异常错误信息给Home.jsp并显示
		 */
		int currentUserid=Integer.parseInt(request.getParameter("currentUserid"));
		String username=request.getParameter("username");
		/*
		 * 获得userid的所有信息在Update.jsp中显示
		 */
		User editedUser=DaoFactory.getUserdao().findByusername(username);
		request.setAttribute("EditedUser", editedUser);
		int userid=editedUser.getUserid();
		PowerCheckService pcs=ServiceFactory.getPowerCheckService();
		if(pcs.generalCheckService(userid))
		{
			request.setAttribute("useridIsGeneral", "Yes");
		}
		else
		{
			request.setAttribute("useridIsGeneral", "No");
		}
		if(pcs.managerCheckService(userid))
		{
			request.setAttribute("useridIsManager", "Yes");
		}
		else
		{
			request.setAttribute("useridIsManager", "No");
		}
		if(pcs.superCheckService(userid))
		{
			request.setAttribute("useridIsSupermanager", "Yes");
		}
		else
		{
			request.setAttribute("useridIsSupermanager", "No");
		}
		if(pcs.generalCheckService(userid)&&!pcs.managerCheckService(userid)&&!pcs.superCheckService(userid))
		{
			if(pcs.managerCheckService(currentUserid)||pcs.superCheckService(currentUserid))
			{
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}else {
				request.setAttribute("nopowermsg", "您不是manager或supermanager");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		}
		else if(pcs.managerCheckService(userid)||pcs.superCheckService(userid)){
			if(pcs.superCheckService(currentUserid))
			{
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}else{
				request.setAttribute("nopowermsg", "您不是supermanager");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
