<%--
  Created by IntelliJ IDEA.
  User: Denis Starovoitenko
  Date: 28.08.2017
  Time: 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Vegetables</title>
</head>
<body>
<h2>Find Vegetable in limits</h2>
<form action="/findVegetable">
    Min value:<br>
    <input type="text" name="min"><br>
    Max value:<br>
    <input type="text" name="max">
    <br><input type="submit" value="Submit"><br>
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
