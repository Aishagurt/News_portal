<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <%@include file="head.jsp"%>
</head>

<body>

<%@include file="navbar.jsp"%>

<div class="container" style="min-height: 500px;">

  <div class="row mt-3">

    <div class="col-6 mx-auto">

      <%

        String emailError = request.getParameter("emailerror");

        if(emailError!=null){

      %>

      <div class="alert alert-danger alert-dismissible fade show" role="alert">

        Email is busy!

        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>

      </div>

      <%

        }

      %>

      <%

        String passwordError = request.getParameter("passworderror");

        if(passwordError!=null){

      %>

      <div class="alert alert-danger alert-dismissible fade show" role="alert">

        Passwords are not same!

        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>

      </div>

      <%

        }

      %>

      <%

        String success = request.getParameter("success");

        if(success!=null){

      %>

      <div class="alert alert-success alert-dismissible fade show" role="alert">

        User added successfully!

        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>

      </div>

      <%

        }

      %>

      <form action="/register" method="post">

        <div class="row">

          <div class="col-12">

            <label>EMAIL</label>

          </div>

        </div>

        <div class="row mt-2">

          <div class="col-12">

            <input type="email" class="form-control" required placeholder="Email" name="email" style="background-color: var(--middle-color);">

          </div>

        </div>

        <div class="row mt-3">

          <div class="col-12">

            <label>PASSWORD</label>

          </div>

        </div>

        <div class="row mt-2">

          <div class="col-12">

            <input type="password" class="form-control" required placeholder="Password" name="password" style="background-color: var(--middle-color);">

          </div>

        </div>

        <div class="row mt-3">

          <div class="col-12">

            <label>REPEAT PASSWORD</label>

          </div>

        </div>

        <div class="row mt-2">

          <div class="col-12">

            <input type="password" class="form-control" required placeholder="Repeat password" name="re_password" style="background-color: var(--middle-color);">

          </div>

        </div>

        <div class="row mt-3">

          <div class="col-12">

            <label>FULL NAME</label>

          </div>

        </div>

        <div class="row mt-2">

          <div class="col-12">

            <input type="text" class="form-control" required placeholder="Full name" name="full_name" style="background-color: var(--middle-color);">

          </div>

        </div>

        <div class="row mt-3">

          <div class="col-12">

            <button class="button-16" role="button">Sign up</button>

          </div>

        </div>

      </form>

    </div>

  </div>

</div>

</body>

</html>


