<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>
    Car edition:
</h1>

<form action="/addCar" method="post">

    <label for="brand">Marka</label>
    <input type="text" name="brand" id="brand">
    <label for="model">Model</label>
    <input type="text" name="model" id="model">
    <label for="bodyType">Typ nadwozia</label>
    <input type="text" name="bodyType" id="bodyType">
    <label for="productionYear">Rok produkcji</label>
    <input type="number" name="productionYear" id="productionYear">
    <label for="color">Kolor</label>
    <input type="text" name="color" id="color">
    <label for="mileage">Przebieg</label>
    <input type="number" name="mileage" id="mileage">
    <form:select path="statuses" id="statuses">
        <c:forEach var="status" items="${statuses}">
            <form:option value="${status}">${status}</form:option>
        </c:forEach>
    </form:select>
    <label for="priceForDay">Stawka za dzień</label>
    <input type="number" name="priceForDay" id="priceForDay">

    <input type="submit" value="Submit">

</form>

</body>
</html>