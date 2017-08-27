<%--
  Created by IntelliJ IDEA.
  User: Denis Starovoitenko
  Date: 27.08.2017
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Salad</title>
</head>
<body>
<h2>Create Salad</h2>

<form action="/createSaladName" method="post">
    Salad name:<br>
    <input type="text" name="saladName" value=""><br/>
    <input type="submit" value="Submit">
</form>

</body>
</html>
