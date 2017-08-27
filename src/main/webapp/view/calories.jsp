<%--
  Created by IntelliJ IDEA.
  User: Denis Starovoitenko
  Date: 28.08.2017
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calories</title>
</head>
<body>
<h2>Calories of the Salad</h2>
<p>Salad: {${name}}</p>
<p>Calories = ${calories}</p>

<jsp:include page="footer.jsp"/>
</body>
</html>
