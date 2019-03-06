package com.ecust.xgp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecust.xgp.domain.User;
import com.ecust.xgp.exception.Nullnameorpassword;
import com.ecust.xgp.exception.PasswordNotMatch;
import com.ecust.xgp.exception.RepeatedUsername;
import com.ecust.xgp.service.UserService;
import com.ecust.xgp.service.impl.ServiceFactory;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserService userservice=ServiceFactory.getUserService();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String qq=request.getParameter("qq");
		String wechat=request.getParameter("wechat");
		String identitycard=request.getParameter("identitycard");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		String confirmpsd = request.getParameter("confirmpsd");
		
		//将注册信息保存到request域中
		User signupuser=new User(username,password,qq,wechat,identitycard,telephone,address);
		request.setAttribute("signupuser", signupuser);		
		request.setAttribute("confirmpsd", confirmpsd);
		try{
			userservice.registerService(signupuser, confirmpsd);
			request.getRequestDispatcher("Loginpage.jsp").forward(request, response);
		}catch(RepeatedUsername e) {
			//捕捉到用户名已存在异常
			String usernameRepeatedmsg = e.getMessage();
			request.setAttribute("usernameRepeatedmsg", usernameRepeatedmsg);
			request.getRequestDispatcher("register.jsp").forward(request, response);;
		}catch(PasswordNotMatch e) {
			//捕捉到输入的密码不一致异常
			String passwordNotmatchmsg=e.getMessage();
			request.setAttribute("passwordNotmatchmsg", passwordNotmatchmsg);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}catch(Nullnameorpassword e) {
			//捕捉到密码或用户名为空
			String Nullnameorpassword=e.getMessage();
			request.setAttribute("Nullnameorpassword", Nullnameorpassword);
			request.getRequestDispatcher("register.jsp").forward(request, response);;
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
}