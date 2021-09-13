<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/finduser.css">
<meta charset="ISO-8859-1">
<title>View Details</title>
</head>
<body>
	<center >
	 <h2>Details updated successfully</h2>
	<table class="styled-table">
    <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Phone No</th>
           	<th>Password</th>
        </tr>
    </thead>
    <tbody>
        <tr class="active-row">
            <td>${username}</td>
            <td>${email}</td>
            <td>${phone}</td>
            <td>${password}</td>
        </tr>
        <!-- and so on... -->
    </tbody>
</table>
	</center>
</body>
</html>