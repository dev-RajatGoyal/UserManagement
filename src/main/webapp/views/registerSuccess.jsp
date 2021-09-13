<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/findall.css">
<title>Registration Successful</title>
</head>
<body>

	<section>
		<!--for demo wrap-->
		<h1>USER REGISTERED SUCCESSFULLY</h1>
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>Username</th>
						<th>Email</th>
						<th>Phone No</th>
						<th>Password</th>
						<th>Gender</th>
						
					</tr>
				</thead>
			</table>
		</div>
		<div class="tbl-content">
			<table cellpadding="0" cellspacing="0" border="0">
				<tbody>
						<tr>
							
							<td>${user.getUsername()}</td>
							<td>${user.getEmail()}</td>
							<td>${user.getPhoneNo()}</td>
							<td>${user.getPassword()}</td>
							<td>${user.getGender()}</td>
							
						</tr>
				</tbody>
			</table>
		</div>
	</section>
	<center><h2><a href="userlogin">Click here to login</a></h2></center>
	<script src="/js/find.js" type="text/javascript"></script>
</body>
</html>