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
import com.ecust.xgp.service.UserService;
import com.ecust.xgp.service.impl.ServiceFactory;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int currentUserid=Integer.parseInt(request.getParameter("currentUserid"));
			String username=request.getParameter("username");
			System.out.println("username="+username+"request.getParameter(\"currentUserid\")="+request.getParameter("currentUserid"));
		/*
		 * 获得userid的所有信息editedUser
		 */
		
		User editedUser=DaoFactory.getUserdao().findByusername(username);
		int userid=editedUser.getUserid();
		/*
		 *检查权限 
		 */
		PowerCheckService pcs=ServiceFactory.getPowerCheckService();
		if(pcs.generalCheckService(userid)&&!pcs.managerCheckService(userid)&&!pcs.superCheckService(userid))
		{
			if(pcs.managerCheckService(currentUserid)||pcs.superCheckService(currentUserid))
			{
				UserService Service = ServiceFactory.getUserService();
				Service.DeleteService(userid);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}else {
				request.setAttribute("nopowermsg", "您不是manager或supermanager");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		}
		else if(pcs.managerCheckService(userid)&&!pcs.superCheckService(userid)){
			if(pcs.superCheckService(currentUserid))
			{
				UserService Service = ServiceFactory.getUserService();
				Service.DeleteService(userid);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
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
