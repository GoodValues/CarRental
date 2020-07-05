<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

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
    <select name="rentalStatus">
        <!--/*@thymesVar id="rentalStatus" type="java"*/-->
        <option th:each="rentalStatus : ${T(com.springteam.carrental.model.dto.RentalStatus).values()}"
                th:th:value="${rentalStatus}" th:text="${rentalStatus}"></option>
    </select>
    <label for="priceForDay">Stawka za dzień</label>
    <input type="number" name="priceForDay" id="priceForDay">

    <input type="submit" value="Submit">

</form>

</body>
</html>