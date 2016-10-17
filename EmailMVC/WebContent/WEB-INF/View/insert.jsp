<%@page import="com.yeon.EmailDao.EmailDao"%>
<%@page import="com.yeon.EmailDao.EmailVo"%>
<%@page import="java.lang.ProcessBuilder.Redirect"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- insert.jsp 는 f5을 누르면 계속적으로 호출하면서 데이터가 저장되어있기 때문에, 
   			response.sendredirect()을 반드시 써서 데이터 중복을 방지해야 합니다!   -->
 <% 
/*   request.setCharacterEncoding("UTF-8");
 	String firstName =request.getParameter("fn");
	String lastName =request.getParameter("ln");
 	String email = request.getParameter("email");
 	
 	EmailVo vo = new EmailVo();
 	
 	vo .setLastName(lastName);
 	vo.setFirstName(firstName);
 	vo.setEmail(email);
 	
 	EmailDao dao = new EmailDao();
 	dao.Insert(vo);
 
 	response.sendRedirect("./show.jsp"); */
 	
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>성공적으로 등록 되었습니다.</h1>
</body>
</html>