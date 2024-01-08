<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Orders</title>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Customer ID</th>
        <th>Customer Name</th>
        <th>Food Name</th>
        <th>Quantity</th>
        <th>Table No</th>
        <th>Delivered</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${foodItems}" var="foodItem">
            <c:forEach items="${foodItem.orders}" var="order">
                    <tr>
                    <c:url var="updateLink" value="/manager/updateOrder">
                        <c:param name="orderId" value="${order.id}" />
                    </c:url>
                    <td>${order.id}</td>
                    <td>${order.customer.id}</td>
                    <td>${order.customer.user.username}</td>
                    <td>${foodItem.name}</td>
                    <td>${order.quantity}</td>
                    <td>${order.tableNo}</td>
                    <td>${order.delivered}</td>
                    <td><a href="${updateLink}">Deliver</a>
                    </tr>
            </c:forEach>
    </c:forEach>
    </tbody>
</table>

<br><br>

<input type="button" value="Home" onclick="window.location.href='home';return false;">

</body>
</html>
