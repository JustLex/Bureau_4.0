<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String userName = (String) session.getAttribute("username");
%>
<html>
<head>
    <title></title>
</head>
<body>

<c:choose>
    <c:when test="${userName == null}">
        <jsp:forward page="/jsp/login.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:forward page="/jsp/menu.jsp" />
    </c:otherwise>
</c:choose>
</body>
</html>