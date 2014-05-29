<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    String userName = (String)(session.getAttribute("username"));
    String userRole = (String)(session.getAttribute("userrole"));
%>
<%@page import="java.util.List"%>
<%@page import="by.zhakov.bureau.model.Specification"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style media="screen" type="text/css">
	body {
		width: 800px;
		margin-left: auto;
	}
	
	.header {
		text-align: right;	
	}
	table {
		margin-left: auto;
		margin-right: auto;
		border-bottom-style: dotted;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		Hello, <%= userName %>. Role: <%= userRole %>
		<form name="logout" action="controller" method="POST" class="logout">
		    <input type="hidden" name="command" value="logout">
		    <input type="submit" value="Logout">
		</form>
	</div>
	<table>
		<thead>
			<tr>
				<th>idSpec</th>
				<th>details</th>
			</tr>
		</thead>
		<tbody>
			<% List <Specification> specs = (List <Specification>)request.getAttribute("specification"); %>
			<% for (int i = 0; i < specs.size(); i++) { %>
			<tr>
			    <td> <%=specs.get(i).getId()%></td>
			    <td> 
				    <form action="controller" method="POST">
				    	<input type="hidden" name="command" value="details">
				    	<input type="hidden" name="spec" value="<%= specs.get(i).getId() %>">
				    	<input type="submit" value="Details">
				    </form>
			    </td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>