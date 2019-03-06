package com.ecust.xgp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecust.xgp.domain.Yg;
import com.ecust.xgp.service.Yg_service;
import com.ecust.xgp.service.impl.Yg_service_impl;
import com.ecust.xgp.utils.ServiceFactory;

/**
 * Servlet implementation class UpdateYgServlet
 */
@WebServlet("/UpdateYgServlet")
public class UpdateYgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateYgServlet() {
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
		Yg_service service = ServiceFactory.getYg_service();
		String EmployeeId = request.getParameter("EmployeeId");
		String EmployeePassword = request.getParameter("EmployeePassword");
		String Salary = request.getParameter("Salary");
		
		Yg yg=new Yg();
		
		try {
			List<Map<String, Object>> ygList = service.findYg(EmployeeId);
			if(ygList!=null && !ygList.isEmpty() && ygList.size()==1)
			{
				for (Map<String, Object> map : ygList) {
					yg.setEmployeeId(EmployeeId);
					yg.setEmployeeName(map.get("EmployeeName").toString());
					yg.setEmployeePassword(EmployeePassword);
					yg.setSalary(Integer.parseInt(Salary));
					try {
						yg.setAttendDate(new SimpleDateFormat("yy-MM-dd").parse(map.get("AttendDate").toString()));
						yg.setAttendDate(new SimpleDateFormat("yy-MM-dd").parse(map.get("Birth").toString()));
					} catch (ParseException e1) {
					
						e1.printStackTrace();
					}
				}
				service.updateYg(yg);
				request.setAttribute("UpdateYgResponseMsg", "更新成功");
			}
			else {
				request.setAttribute("UpdateYgResponseMsg", "更新失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
