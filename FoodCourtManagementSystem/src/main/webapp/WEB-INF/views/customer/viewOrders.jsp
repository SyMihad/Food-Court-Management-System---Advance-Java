<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Admins</title>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Restaurant Name</th>
        <th>Food Name</th>
        <th>Quantity</th>
        <th>Table No</th>
        <th>Delivered</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <c:forEach items="${order.foodItems}" var="foodItem">
                    <td>${foodItem.restaurant.name}</td>
                    <td>${foodItem.name}</td>
            </c:forEach>
            <td>${order.quantity}</td>
            <td>${order.tableNo}</td>
            <td>${order.delivered}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<input type="button" value="Place an Order" onclick="window.location.href='restaurantList';return false;">
<input type="button" value="Home" onclick="window.location.href='home';return false;">

</body>
</html>
