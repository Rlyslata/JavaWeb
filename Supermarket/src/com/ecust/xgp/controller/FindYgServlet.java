package com.ecust.xgp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecust.xgp.service.impl.Yg_service_impl;
import com.ecust.xgp.utils.ServiceFactory;

/**
 * Servlet implementation class FindYgServlet
 */
@WebServlet("/FindYgServlet")
public class FindYgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindYgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Yg_service_impl service = ServiceFactory.getYg_service();
		
		String employeeid=request.getParameter("employeeid");
		try {
			List<Map<String,Object>> yg = service.findYg(employeeid);
			request.setAttribute("ygListMap", yg);
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("EmployeeNoFound", "没有查询到任何信息");
			e.printStackTrace();
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
