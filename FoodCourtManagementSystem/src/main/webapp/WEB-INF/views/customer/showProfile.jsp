<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Show Profile</title>
</head>
<body>

<div align='center'>

<h1>Show Profile</h1>

<form:form action="updateProfile" modelAttribute="customer">

    <label for="userId">User Id:</label>
    <form:input path="user.id" id="userId" readonly="true"/>
    <form:errors path="user.id"/>

    <br><br>

    <label for="customerId">Customer Id:</label>
    <form:input path="id" id="customerId" readonly="true"/>
    <form:errors path="id"/>

    <br><br>


    <label for="firstName">First Name:</label>
    <form:input path="user.firstName" id="firstName" readonly="true"/>
    <form:errors path="user.firstName"/>

    <br><br>

    <label for="lastName">Last Name:</label>
    <form:input path="user.lastName" id="lastName" readonly="true"/>
    <form:errors path="user.lastName"/>

    <br><br>

    <label for="userName">User Name:</label>
    <form:input path="user.username" id="userName" readonly="true"/>
    <form:errors path="user.username"/>

    <br><br>

    <label for="password">Password:</label>
    <form:input path="user.password" id="password" readonly="true"/>
    <form:errors path="user.password"/>

    <br><br>

    <label for="enabled">Enabled:</label>
    <form:input path="user.enabled" id="enabled" readonly="true"/>
    <form:errors path="user.enabled"/>

    <br><br>

    <label for="createdOn">Created On:</label>
    <form:input path="user.createdOn" id="createdOn" readonly="true"/>
    <form:errors path="user.createdOn"/>

    <br><br>

    <label for="email">Email:</label>
    <form:input type="email" path="user.email" id="email" readonly="true"/>
    <form:errors path="user.email"/>

    <br><br>

    <label for="gender">Gender:</label>
    <form:radiobutton path="user.gender" id="gender" value="MALE"/>MALE
    <form:radiobutton path="user.gender" id="gender" value="FEMALE"/>FEMALE
    <form:errors path="user.gender"/>

    <br><br>

    <label for="phoneNo">Phone No:</label>
    <form:input type="number" path="phoneNo" id="phoneNo" readonly="true"/>
    <form:errors path="phoneNo"/>

    <br><br>

</form:form>

<input type="button" value="Home" onclick="window.location.href='home';return false;">

</div>

</body>
</html>