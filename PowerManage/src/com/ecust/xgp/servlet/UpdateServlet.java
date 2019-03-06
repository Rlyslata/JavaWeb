package com.ecust.xgp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecust.xgp.domain.User;
import com.ecust.xgp.exception.RepeatedUsername;
import com.ecust.xgp.service.UserService;
import com.ecust.xgp.service.impl.ServiceFactory;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		User user=new User();
		int userid=Integer.parseInt(request.getParameter("userid"));
		user.setUserid(userid);
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setQq(request.getParameter("QQ"));   
		user.setWechat(request.getParameter("Wechat"));
		user.setIdentitycard(request.getParameter("identitycard"));
		user.setTelephone(request.getParameter("telephone"));
		user.setAddress(request.getParameter("address"));
		UserService service=ServiceFactory.getUserService();
		try {
			service.UpdateService(user);
			//无异常则转发至登录首页
			request.getRequestDispatcher("Loginpage.jsp").forward(request, response);
		}catch(RepeatedUsername e) {
			//捕捉到异常，保存异常信息，转发Home.jsp
			request.setAttribute("repeatedusernamemsg", e.getMessage());
			request.getRequestDispatcher("Home.jsp").forward(request, response);;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
