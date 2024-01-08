<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Orders</title>
</head>
<body>
<div align="center">
<table border="1">
    <thead>
    <tr>
        <th>Restaurant Name</th>
        <th>Food Items</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${restaurants}" var="restaurant">
            <tr>
            <td>${restaurant.name}</td>
            <td>
            <c:forEach items="${restaurant.foodItems}" var="foodItem">
                    <table >
                    <td>${foodItem.name}<b> :</b></td>
                    <td>${foodItem.price}</td>
                    </table>
            </c:forEach>
            </td>
            </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<input type="button" value="Home" onclick="window.location.href='home';return false;">
</div>
</body>
</html>
