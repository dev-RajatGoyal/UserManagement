<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">


<link rel="stylesheet" href="/css/update.css">
<title>Update Details</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <div class="container-fluid">
    <a class="navbar-brand" href="/">User Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
         
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="viewdetails">View Details</a>
        </li> 
       <!--  <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="updatedetails">Update Details</a>
        </li> -->
		<li class="nav-item">
          <a class="nav-link" href="Home">Logout</a>
        </li>
      </ul>

    </div>
  </div>
</nav>

	
<div class="login-box">
  <h2>Update Details</h2>
  <form action="updated" method="post">
   <!--  <div class="user-box">
      <input type="text" name="username" value="">
      <label>Username</label>
    </div> -->
    <div class="user-box">
      <input type="text" name="email"  value="${email}">
      <label>Email</label>
    </div>
    <div class="user-box">
      <input type="text" name="phoneNo" value="${phone}" >
      <label>Phone No</label>
    </div>
    <div class="user-box">
      <input type="password" name="password" value="${password}">
      <label>Password</label>
    </div>
    <input class="submit" type="submit" value="Update" >
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
   
</body>
</html>