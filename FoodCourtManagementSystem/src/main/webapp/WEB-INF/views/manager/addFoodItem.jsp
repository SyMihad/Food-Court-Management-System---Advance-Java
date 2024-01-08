<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Food Item</title>
</head>
<body>

<div align='center'>

<h1>Add Food Item</h1>

<form:form action="storeFoodItem" modelAttribute="foodItem">

    <label for="name">Name:</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>

    <br><br>

    <label for="price">Price:</label>
    <form:input path="price" id="price"/>
    <form:errors path="price"/>

   <br><br>


<input type="submit">

</form:form>
</div>

</body>
</html>