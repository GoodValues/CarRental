<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>Lista samochodów</h1>

<a href="/addCar">Add new car</a>
<table>
    <tr>
        <th>Marka</th>
        <th>Model</th>
        <th>Typ nadwozia</th>
        <th>Rok produkcji</th>
        <th>Kolor</th>
        <th>Przebieg</th>
        <th>Status</th>
        <th>Cena za dzień wypożyczenia</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach var="car" items="${carsList}">
        <tr>
            <td>${car.brand}</td>
            <td>${car.model}</td>
            <td>${car.bodyType}</td>
            <td>${car.productionYear}</td>
            <td>${car.color}</td>
            <td>${car.mileage}</td>
            <td>${car.rentalStatus}</td>
            <td>${car.priceForDay}</td>
            <td><a href="/deleteCar?id=${car.id}">Usuń</a></td>
            <td><a href="/editCar?id=${car.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>