package com.yeon.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.r;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

import com.yeon.EmailDao.EmailDao;
import com.yeon.EmailDao.EmailVo;

@WebServlet("/EL")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if ("form".equals(action)) {
			//form
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/form.jsp");
			rd.forward(request, response);
			
		} else if ("insert".equals(action)) {
			//insert
			
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");
		
			EmailVo vo = new EmailVo();
			vo.setEmail(email);
			vo.setLastName(lastName);
			vo.setFirstName(firstName);
			
			EmailDao dao = new EmailDao();
			dao.Insert(vo);
			
			response.sendRedirect("/EmailMVC/EL");
			
			
			
		} else if ("delete".equals(action)) {
			//delete
		} else {
			//default action
			
			//list
			EmailDao dao= new EmailDao();
			List<EmailVo> list = dao.getList();
			
			// forward 대상에게 데이터 보내기
			request.setAttribute("list", list);
			request.setAttribute("MyNumber",new Integer(10));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/index.jsp");
			rd.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
