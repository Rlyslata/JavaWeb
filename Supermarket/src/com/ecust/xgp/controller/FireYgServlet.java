package com.ecust.xgp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecust.xgp.service.Yg_service;
import com.ecust.xgp.service.impl.Yg_service_impl;
import com.ecust.xgp.utils.ServiceFactory;

/**
 * Servlet implementation class FireYgServlet
 */
@WebServlet("/FireYgServlet")
public class FireYgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FireYgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String EmployeeId = request.getParameter("EmloyeeId");
		
		Yg_service service = ServiceFactory.getYg_service();
		try {
			List<Map<String,Object>> yg = service.findYg(EmployeeId);			
			if(yg!=null && !yg.isEmpty() &&yg.size()==1)
			{
				//Id存在
				service.fireYg(EmployeeId);
				request.setAttribute("FireYgResponseMsg", "删除成功");	
			}
			else
			{
				request.setAttribute("FireYgResponseMsg", "Id不存在");	
			}
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		} catch (Exception e) {
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
