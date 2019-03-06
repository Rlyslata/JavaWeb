package com.ecust.xgp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecust.xgp.exception.LoginErrorException;
import com.ecust.xgp.service.CheckService;
import com.ecust.xgp.utils.ServiceFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//		request.getRequestDispatcher("test.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.getWriter().write("卧槽");
		String currentUserId=request.getParameter("userId");
		String currentUserPassword=request.getParameter("password");
		System.out.println(currentUserId+","+currentUserPassword);
		/*
		 * 回显
		 */
//		HttpSession session = request.getSession();
//		session.setAttribute("currentUserId", currentUserId);
//		session.setAttribute("currentUserPassword", currentUserPassword);
//		/*
//		 * 检查账号密码
//		 */
//		CheckService checkService = ServiceFactory.getCheckService();
//		try {
//			checkService.LoginCheck(currentUserId, currentUserPassword);
//			System.out.println("执行到了这！");
//			request.getRequestDispatcher("test.jsp").forward(request, response);
//		}catch(LoginErrorException e) {
//			request.setAttribute("LoginErrorMesssage",e.getMessage());
//			request.getRequestDispatcher("Loginpage.jsp").forward(request, response);
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
	}

}
