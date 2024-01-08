<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Place Order</title>
</head>
<body>

<div align='center'>

<h1>Place Order</h1>

<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${foodItems}" var="foodItem">
        <tr>
            <td>${foodItem.name}</td>
            <td>${foodItem.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<form:form action="storeOrder" modelAttribute="order">

    <label>Food Item:</label>
    <form:select path="foodItems">
        <c:forEach items="${foodItems}" var="foodItem">
            <form:option value="${foodItem.id}" label="${foodItem.name}" />
        </c:forEach>
    </form:select>

    <br><br>

    <label for="quantity">Quantity:</label>
    <form:input path="quantity" id="quantity"/>
    <form:errors path="quantity"/>

    <br><br>

    <label for="tableNo">Table No:</label>
    <form:input path="tableNo" id="tableNo"/>
    <form:errors path="tableNo"/>

    <br><br>

<input type="submit">

</form:form>
</div>

</body>
</html>