package com.ecust.xgp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecust.xgp.domain.User;
import com.ecust.xgp.exception.PasswordError;
import com.ecust.xgp.exception.UserNotFound;
import com.ecust.xgp.service.UserService;
import com.ecust.xgp.service.impl.ServiceFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PowerManager");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			
			UserService userservice=ServiceFactory.getUserService();
			User currentUser=userservice.LoginService(username,password);
			//保存的登录信息
			request.setAttribute("loginname", username);
			request.setAttribute("loginpassword", password);
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", currentUser);
			
			//LoginService业务处理无异常转发至首页homepage.jsp
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}catch (UserNotFound e){
			request.setAttribute("nameErrormsg",e.getMessage());
			//用户名错误异常登录页回显
			request.getRequestDispatcher("Loginpage.jsp").forward(request, response);
		}catch(PasswordError e) {
			request.setAttribute("psdErrormsg", e.getMessage());
			//密码错误异常登录页回显
			request.getRequestDispatcher("Loginpage.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
