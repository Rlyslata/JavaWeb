package com.ecust.xgp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecust.xgp.domain.Yg;
import com.ecust.xgp.exception.Yg_idIncorrectException;
import com.ecust.xgp.service.Yg_service;
import com.ecust.xgp.utils.ServiceFactory;

/**
 * Servlet implementation class HireYgServlet
 */
@WebServlet("/HireYgServlet")
public class HireYgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HireYgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 取出request域中放置yg对象
		 */
		Yg yg=new Yg();
		yg.setEmployeeId(request.getParameter("EmployeeId"));
		yg.setEmployeeName(request.getParameter("EmployeeName"));
		yg.setEmployeePassword(request.getParameter("EmployeePassword"));
		yg.setSalary(Integer.parseInt(request.getParameter("Salary")));
		try {
			yg.setAttendDate(new SimpleDateFormat("yy-MM-dd").parse(request.getParameter("AttendDate")));
			yg.setAttendDate(new SimpleDateFormat("yy-MM-dd").parse(request.getParameter("Birth")));
		} catch (ParseException e1) {
		
			e1.printStackTrace();
		}
		
		try {
			/**
			 * 获取service
			 * 调用hireYg方法
			 */
			Yg_service service=ServiceFactory.getYg_service();
			service.hireYg(yg);
		}catch(Yg_idIncorrectException e) {//捕捉到Yg_idIncorrectException异常
			/**
			 * 将错误msg放入request域中
			 * 重定向到原网页
			 */
			request.setAttribute("Yg_idIncorrectExceptionMessage",e.getMessage());
			// TODO
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(Exception e) {
			
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
