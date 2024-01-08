<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Food Items</title>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${foodItems}" var="foodItem">
        <tr>
            <c:url var="updateLink" value="/manager/editFoodItem">
                <c:param name="foodId" value="${foodItem.id}" />
            </c:url>
            <c:url var="deleteLink" value="/manager/deleteFoodItem">
                <c:param name="foodId" value="${foodItem.id}" />
            </c:url>
            <td>${foodItem.id}</td>
            <td>${foodItem.name}</td>
            <td>${foodItem.price}</td>
            <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<input type="button" value="Add Food Item" onclick="window.location.href='addFoodItem';return false;">
<input type="button" value="Home" onclick="window.location.href='home';return false;">

</body>
</html>
