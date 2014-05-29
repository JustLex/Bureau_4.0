<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    String userName = (String)(session.getAttribute("username"));
    String userRole = (String)(session.getAttribute("userrole"));
%>
<%@page import="java.util.List"%>
<%@page import="by.zhakov.bureau.model.SpecificationDetails"%>
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
	table, thead, tbody {
		margin-left: auto;
		margin-right: auto;
		border-bottom-style: dotted;
	}
	td {
		text-align: center;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
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
				<th>idDetails</th>
				<th>requiredWorkers</th>
				<th>requiredQualificationId</th>
			</tr>
		</thead>
		<tbody>
			<% List <SpecificationDetails> specs = (List <SpecificationDetails>)request.getAttribute("details"); %>
			<% for (int i = 0; i < specs.size(); i++) { %>
			<tr>
			    <td> <%=specs.get(i).getId()%></td>
			    <td> <%=specs.get(i).getRequiredWorkersCount()%></td>
			    <td> <%=specs.get(i).getIdRequiredQualification()%></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>