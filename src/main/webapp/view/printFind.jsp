<%--
  Created by IntelliJ IDEA.
  User: Denis Starovoitenko
  Date: 28.08.2017
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Print Find</title>
</head>
<body>
<h2>List Vegetables after finding</h2>
<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Vegetable</th>
        <th>Calories</th>
        <th>Protein</th>
        <th>Fat</th>
        <th>Carbohydrate</th>
        <th>Weight</th>
    </tr>
    <c:forEach items="${result}" var="entry" >
        <tr>
            <td>${entry.key.name}</td>
            <td>${entry.key.calorie}</td>
            <td>${entry.key.protein}</td>
            <td>${entry.key.fat}</td>
            <td>${entry.key.carbohydrate}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
