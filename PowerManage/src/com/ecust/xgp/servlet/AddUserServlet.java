package com.ecust.xgp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecust.xgp.exception.NoPower;
import com.ecust.xgp.service.PowerCheckService;
import com.ecust.xgp.service.impl.ServiceFactory;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PowerCheckService要处理的业务2~3
		 *1.请求页面给出正在进行的操作的名称，删除等操作还需给出被操作用户id，获取当前进行操作的用户di（currentUser被保存在request域中）
		 *2.根据currentUser.userid，查询select distinct sysopname from user_role as a,role_sysop as b,sysop as c
		 *where a.roleid=b.roleid and b.sysopid=c.sysopid and a.userid=?
		 *3.检查真在进行的操作是否在2中获得的操作名称集合中，若在则有权限执行操作，没有权限抛出异常
		 */
		/*
		 * 1.本servlet根据操作名字进行不同的业务处理，service方法处理结果保存到request域中
		 */
		
		/*
		 * 获取被操作用户id
		 * int optedUserid = (int) request.getAttribute("optedUserid");
		 */
		/*
		 * 获取当前用户id
		 * User currentUser = (User) request.getAttribute("currentUser");
		 * int currentUserid = currentUser.getUserid();
		 */
		/**
		 * 调用AddCheckService检查是否有权限
		 */
		try {
			PowerCheckService service=ServiceFactory.getPowerCheckService();
			int currentUserid = Integer.parseInt(request.getParameter("currentUserid"));
			service.AddUserCheckService(currentUserid);	
			request.getRequestDispatcher("adduser.jsp").forward(request, response);
		}catch(NoPower e) {
//			System.out.println("第一個捕捉到了NoPower");
			request.setAttribute("nopowermsg", e.getMessage().toString());
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(request.getParameter("currentUserid")+"第二個捕捉到了NoPower");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
