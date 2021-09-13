<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/findall.css">
<title>All Users details</title>
</head>
<body>

	<section>
		<!--for demo wrap-->
		<h1>ALL USER DETAILS</h1>
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>Id</th>
						<th>Username</th>
						<th>Email</th>
						<th>Phone No</th>
						<th>Gender</th>
						<th>Delete</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="tbl-content">
			<table cellpadding="0" cellspacing="0" border="0">
				<tbody>

					<c:forEach var="user" items="${listOfUsers}">
							
						<tr>
							<td>${user.getId()}</td>
							<td>${user.getUsername()}</td>
							<td>${user.getEmail()}</td>
							<td>${user.getPhoneNo()}</td>
							<td>${user.getGender()}</td>
							
							<td>
								<form action="userdeleted" method="post">
									<input type="hidden" name="userName" value="${user.getUsername()}">
									<input type="submit" value="Delete">
								</form>
							</td>
							<%-- <td> <a href="admindashboard?userId=${user.getId()}">DELETE</a></td>
							
							 --%>
							<%--  <%! String ID= ${user.getId()}; %>
							<td><a href="delete.jsp?id=<%=ID%>">DELETE</a></td> --%>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
	<script src="/js/find.js" type="text/javascript"></script>
</body>
</html>