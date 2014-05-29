<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String error = (String)session.getAttribute("error");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<style media="screen" type="text/css">
		body {
			width: 800px;
			text-align: center;
		}
		
		.login {
			width: 400px;
			background-color: #DDD;	
		}
	</style>
	<title>Bureau 4.0</title>
</head>
<body>
	<h1>Login Page</h1>
	<div class="login">
		<form action="BureauServlet" method="post">
			<input type="hidden" name="command" value="login">
			<br />Username:<input type="text" name="username"> <br />
			Password:<input type="password" name="password"> <br /> 
			<input
				type="submit" value="Submit">
		</form>
	</div>
</body>
</html>