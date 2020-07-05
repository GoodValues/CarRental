<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>
    Car edition:
</h1>

<form action="/editCar" method="post">

    <label for="brand">Marka</label>
    <input type="text" name="brand" id="brand" value="${car.brand}">
    <label for="model">Model</label>
    <input type="text" name="model" id="model" value="${car.model}">
    <label for="bodyType">Typ nadwozia</label>
    <input type="text" name="bodyType" id="bodyType" value="${car.bodyType}">
    <label for="productionYear">Rok produkcji</label>
    <input type="number" name="productionYear" id="productionYear" value="${car.productionYear}">
    <label for="color">Kolor</label>
    <input type="text" name="color" id="color" value="${car.color}">
    <label for="mileage">Kolor</label>
    <input type="number" name="mileage" id="mileage" value="${car.mileage}">

<%--<select name="rentalStatus">--%>
<%--    <!--/*@thymesVar id="rentalStatus" type="java"*/-->--%>
<%--    <option th:each="rentalStatus : ${T(com.springteam.carrental.model.dto.RentalStatus).values()}"--%>
<%--    th:th:value="${rentalStatus}" th:text="${rentalStatus}"></option>--%>
<%--</select>--%>
    <label for="priceForDay">Stawka za dzień</label>
    <input type="number" name="priceForDay" id="priceForDay" value="${car.priceForDay}">

    <input type="hidden" name="id" value="${car.id}">
    <input type="submit" value="Edit">

</form>

</body>
</html>