<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Restaurants</title>
</head>
<body>

<table border="1" align="center">
    <thead>
    <tr>
        <th>Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${restaurants}" var="restaurant">
        <tr>
            <c:url var="selectLink" value="/customer/selectFoodItem">
                <c:param name="restaurantId" value="${restaurant.id}" />
            </c:url>
            <td>${restaurant.name}</td>
            <td><a href="${selectLink}">Select</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<input type="button" value="Home" onclick="window.location.href='home';return false;">

</body>
</html>
