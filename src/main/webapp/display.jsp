<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Students List</title>
    <link rel="stylesheet" href="displaystyles.css">
</head>
<body>
    <div class="container">
        <h1>Students List</h1>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Date</th>
                    <th>Gender</th>
                    <th>Password</th>
                    <th>Action </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${studentsList}">
                    <tr>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>${student.date}</td>
                        <td>${student.gender}</td>
                        <td>${student.password}</td>
                        
                        <td>
                    		<a href="ServletController?updateinfo=${student.name}" class="btn">Update</a>
                    		<a href="ServletController?deleteinfo=${student.name}" class="btn btn-danger">Delete</a>
                		</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
