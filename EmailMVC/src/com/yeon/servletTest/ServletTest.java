package com.yeon.servletTest;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destroy");
	}

	public ServletConfig getServletConfig() {
		System.out.println("ServletConfig");
		return null;
	}

	public String getServletInfo() {
		super.getServletInfo();
		System.out.println("getServletInfo");
		return null; 
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPut");
		}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doDelete");
	}

	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doHead");
	}

	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doOptions");
	}

	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doTrace");
	}

}
