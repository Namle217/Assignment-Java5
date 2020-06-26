<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String view = request.getParameter("view");
	if(view.startsWith("login/")){
		pageContext.forward("blank-layout.jsp");
	}else{
		if(view.startsWith("user/")){
			pageContext.forward("user-layout.jsp");
		}else{
			pageContext.forward("admin-layout.jsp");
		}
	}
%>