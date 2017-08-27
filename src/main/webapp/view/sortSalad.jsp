<%--
  Created by IntelliJ IDEA.
  User: Denis Starovoitenko
  Date: 28.08.2017
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sort Salad</title>
</head>
<body>

<h2>Sort salad by some attribute</h2>
<form action="/sortSalad">
    <input type="radio" name="sort" value="name" checked> Sort by name <br>
    <input type="radio" name="sort" value="calorie" > Sort by calorie <br>
    <input type="radio" name="sort" value="protein" > Sort by protein <br>
    <input type="radio" name="sort" value="weight" > Sort by weight <br>
    <input type="submit" value="Submit">
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>
