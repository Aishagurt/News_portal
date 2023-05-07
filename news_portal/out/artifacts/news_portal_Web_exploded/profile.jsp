<%--
  Created by IntelliJ IDEA.
  User: Aisha
  Date: 05.05.2023
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Profile</title>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container" style="min-height: 500px;">
    <div class="row mt-3">
        <div class="col-12">
                <div class="col-11 mx-auto p-3" style="background-color: lightgrey; margin-top: 20px;">
                    <form id="edit-form" action="/editprofile" method="POST">

                        <div class="row">

                            <div class="col-12">

                                <label>EMAIL</label>

                            </div>

                        </div>

                        <div class="row mt-2">

                            <div class="col-12">

                                <input type="email" class="form-control" name="email" readonly value="<%=curr.getEmail()%>">

                            </div>

                        </div>

                        <div class="row mt-3">

                            <div class="col-12">

                                <label>PASSWORD</label>

                            </div>

                        </div>

                        <div class="row mt-2">

                            <div class="col-12">

                                <input type="password" class="form-control" name="password" readonly value="<%=curr.getPassword()%>">

                            </div>

                        </div>

                        <div class="row mt-3">

                            <div class="col-12">

                                <label>FULL NAME</label>

                            </div>

                        </div>

                        <div class="row mt-2">

                            <div class="col-12">

                                <input type="text" class="form-control" name="full_name" readonly value="<%=curr.getFullName()%>">

                            </div>

                        </div>

                        <div class="row mt-3">

                            <div class="col-12">

                                <button class="button-16" type="button" id="edit-btn" onclick="enableEdit()" style="display:block;">Edit info</button>

                                <button class="button-16" type="submit" id="submit-btn" style="display: none" >Save Changes</button>
                            </div>

                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function enableEdit() {
        const form = document.getElementById("edit-form");
        const inputs = form.getElementsByTagName("input");

        for (let i = 0; i < inputs.length; i++) {
            inputs[i].removeAttribute("readonly");
        }

        const submitBtn = document.getElementById("submit-btn");
        submitBtn.style.display = "block";

        const editBtn = document.getElementById("edit-btn");
        editBtn.style.display = "none";
    }
</script>
</body>
</html>
