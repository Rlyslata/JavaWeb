package com.ecust.xgp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecust.xgp.domain.SearchBean;
import com.ecust.xgp.service.UserService;
import com.ecust.xgp.service.impl.ServiceFactory;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int rawNum=5;
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			String currentPage=request.getParameter("currentPage");
			int cp=Integer.parseInt(currentPage);
			String field=request.getParameter("field");
			request.setAttribute("field", field);
			System.out.println("field"+field);
			UserService service=ServiceFactory.getUserService();
			int start=(cp-1)*rawNum;
			SearchBean bean=service.searchService(start, rawNum, field);
			HttpSession session = request.getSession();
//			session.removeAttribute("bean");
			//当前页更新
			bean.setCurrentPage(cp);
			session.setAttribute("bean", bean);
			System.out.println("-------------bean-----------------");
			System.out.println(bean.toString());
			System.out.println("--------------bean----------------");

			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}catch(Exception e) {
			throw new  RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
