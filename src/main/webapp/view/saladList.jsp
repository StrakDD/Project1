<%--
  Created by IntelliJ IDEA.
  User: Denis Starovoitenko
  Date: 27.08.2017
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Salad List</title>
</head>
<body>
<h2>Salad List</h2>

<table border="1" cellpadding="5" cellspacing="1" >
    <c:forEach items="${saladList}" var="salad" >
        <tr>
            <td>${salad}</td>
            <td><a href="printList?name=${salad}">View</a> </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>

</body>
</html>
