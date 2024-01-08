<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<div align='center'>

<h1>Register</h1>

<form:form action="store" modelAttribute="customerDto">

    <label for="firstName">First Name:</label>
    <form:input path="firstName" id="firstName"/>
    <form:errors path="firstName"/>

    <br><br>

    <label for="lastName">Last Name:</label>
    <form:input path="lastName" id="lastName"/>
    <form:errors path="lastName"/>

    <br><br>

    <label for="username">User Name:</label>
    <form:input path="username" id="username"/>
    <form:errors path="username"/>

    <br><br>

    <label for="email">Email:</label>
    <form:input type="email" path="email" id="email"/>
    <form:errors path="email"/>

    <br><br>

    <label for="gender">Gender:</label>
    <form:radiobutton path="gender" id="gender" value="MALE"/>MALE
    <form:radiobutton path="gender" id="gender" value="FEMALE"/>FEMALE
    <form:errors path="gender"/>

    <br><br>

    <label for="phoneNo">Phone No:</label>
    <form:input type="mumber" path="phoneNo" id="phoneNo"/>
    <form:errors path="phoneNo"/>

    <br><br>

    <label for="password">Password:</label>
    <form:input type="password" path="password" id="password"/>
    <form:errors path="password"/>

    <br><br>

    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>

<input type="submit">

</form:form>
</div>

</body>
</html>