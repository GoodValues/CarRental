<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>
    Office edition:
</h1>

<form action="/editOffice" method="post">

    <label for="name">Nazwa</label>
    <input type="text" name="name" id="name" value="${rentalOffice.name}">
    <label for="webPage">Strona internetowa</label>
    <input type="text" name="webPage" id="webPage" value="${rentalOffice.webPage}">
    <label for="address">Adres</label>
    <input type="text" name="address" id="address" value="${rentalOffice.address}">
    <label for="owner">Właściciel</label>
    <input type="text" name="owner" id="owner" value="${rentalOffice.owner}">
    <label for="logotype">Logotyp</label>
    <input type="text" name="logotype" id="logotype" value="${rentalOffice.logotype}">

    <input type="hidden" name="id" value="${rentalOffice.id}">
    <input type="submit" value="Edit">

</form>

</body>
</html>