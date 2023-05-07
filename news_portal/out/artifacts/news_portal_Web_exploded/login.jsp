<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
  <%@include file="head.jsp"%>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
  <div class="row">
      <div class ="col-6 mx-auto">
        <form action="/login" method="post">
          <div class="row">
            <div class="col-12">
              <label>Email:</label>
            </div>
          </div>
          <div class="row mt-2">
            <div class="col-12">
              <input type="email" class="form-control" name="email" required placeholder="Insert email" style="background-color: var(--middle-color);">
            </div>
          </div>
          <div class="row mt-3">
            <div class="col-12">
              <label>Password:</label>
            </div>
          </div>
          <div class="row mt-2">
            <div class="col-12">
              <input type="password" class="form-control" name="password" required placeholder="Insert password" style="background-color: var(--middle-color);">
            </div>
          </div>
          <div class="row mt-3">
            <div class="col-12">
              <button class="button-16" role="button">Sign in</button>
            </div>
          </div>
        </form>
      </div>
  </div>
</div>
</body>
</html>
