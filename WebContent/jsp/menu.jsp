<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = (String)(session.getAttribute("username"));
    String userRole = (String)(session.getAttribute("userrole"));
%>
<%@page import="java.util.List"%>
<%@page import="by.zhakov.bureau.model.Project"%>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	Hello, ${userName}. Role: ${userRole}
	<div>
		<form name="logout" action="controller" method="POST" class="logout">
		    <input type="hidden" name="command" value="logout">
		    <input type="submit" value="Logout">
		</form>
	</div>
</body>
</html>
