<%--
  Created by IntelliJ IDEA.
  User: Denis Starovoitenko
  Date: 27.08.2017
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salad Vegetable</title>
</head>
<body>
<h2>Create Vegetable for the Salad</h2>

<form action="/createSaladVegetable" method="post">
    <fieldset>
        <legend>Vegetable</legend>
            Name:<br>
            <input type="text" name="nameVegetable"> <br>
            Calories:<br>
            <input type="text" name="calories"> <br>
            Protein:<br>
            <input type="text" name="protein"> <br>
            Fat:<br>
            <input type="text" name="fat"> <br>
            Carbohydrate:<br>
            <input type="text" name="carbohydrate"> <br>
            Type:<br>
            <input type="radio" name="type" value="fruit" checked> FruitVegetable
            <input type="radio" name="type" value="vegetative"> VegetativeVegetable
            Specified Type:<br>
            for Fruit Vegetable: {SEEDS, FRUITS} <br>
            for Vegetative Vegetable: {ROOTS, TUBERS, STEMS, LEAVES, BULBS, OTHERS} <br>
            <input type="text" name="typeVegetable"> <br>
    </fieldset>
    <fieldset>
        <legend>Vegetable Weight</legend>
        Weight:<br>
        <input type="text" name="weight"> <br>
    </fieldset>
    <input type="submit" value="Submit">
</form>

<form action="/finishSalad">
    <input type="submit" value="Finish Salad" />
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
