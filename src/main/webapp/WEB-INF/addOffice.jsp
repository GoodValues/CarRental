<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>
    Office adding:
</h1>

<form action="/addRentalOffice" method="post">

    <label for="name">Nazwa</label>
    <input type="text" name="name" id="name">
    <label for="webPage">Strona internetowa</label>
    <input type="text" name="webPage" id="webPage">
    <label for="address">Adres</label>
    <input type="text" name="address" id="address">
    <label for="owner">Właściciel</label>
    <input type="text" name="owner" id="owner">
    <label for="logotype">Logotyp</label>
    <input type="text" name="logotype" id="logotype">

    <input type="hidden" name="id">
    <input type="submit" value="Dodaj">

</form>

</body>
</html>