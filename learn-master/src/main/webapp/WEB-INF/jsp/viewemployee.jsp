<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>View Employee</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Employee ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>

        <c:if test="${status}">
            <div>Successfully added Employee ${employee.firstName}</div>
        </c:if>
        <tr>
            <td>${employee.id}</td><br/>
            <td>${employee.firstName}</td><br/>
            <td>${employee.lastNme}</td><br/>
            <td>${employee.email}</td><br/>
        </tr>
    </tbody>
</table>
</body>
</html>