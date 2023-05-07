<%@ page import="shop.entities.Categories" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="shop.entities.Posts" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="head.jsp"%>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Post</title>
</head>
<body>
  <%@include file="navbar.jsp"%>
  <div class="container" style="min-height: 500px;">

    <div class="row mt-3">

      <div class="col-8 mx-auto">

        <%

          String success = request.getParameter("success");
          if(success!=null){

        %>

        <div class="alert alert-success alert-dismissible fade show" role="alert">

          Post published successfully!

          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>

        </div>

        <%

          }

        %>

        <%

          String error = request.getParameter("error");

          if(error!=null){

        %>

        <div class="alert alert-danger alert-dismissible fade show" role="alert">

          Fill in all the fields!

          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>

        </div>

        <%

          }

        %>

        <%
          ArrayList<Categories> categoriesArrayList = (ArrayList<Categories>) session.getAttribute("categories");
          Posts post = (Posts) session.getAttribute("post");

          if(post!=null && request.getParameter("id") != null){

        %>
        <form action="/post" method="post">

          <div class="row">

            <div class="col-12">

              <label style="color: var(--secondary-color)"> Title </label>

            </div>

          </div>

          <div class="row mt-2">

            <div class="col-12">

              <input type="text" class="form-control" name="title" value="<%=post.getTitle()%>" placeholder="Title" style="background: var(--middle-color)">
            </div>

          </div>

          <div class="row">
          </div>

          <div class="row mt-2">
            <div class="col-12">
              <select class="form-select" name="category" style="background: var(--middle-color)">
                <%
                  if(categoriesArrayList!= null){
                    for (Categories category : categoriesArrayList) {
                %>
                <option value="<%=category.getId()%>"><%=category.getName()%></option>
                <% } }%>
              </select>
            </div>
          </div>

          <div class="row mt-3">

            <div class="col-12">

              <label>CONTENT </label>

            </div>

          </div>

          <div class="row mt-2">

            <div class="col-12">

              <textarea class="form-control" name="content" rows="5" id="textareaValue" placeholder="Content" style="background: var(--middle-color)">${requestScope.textareaValue}</textarea>

            </div>

          </div>


          <div class="row mt-3">

            <div class="col-12">

              <button class="button-16" role="button">Edit post</button>

            </div>

          </div>

        </form>

        <% }else{ %>
        <form action="/post" method="post">

          <div class="row">

            <div class="col-12">

              <label style="color: var(--secondary-color)">TITLE </label>

            </div>

          </div>

          <div class="row mt-2">

            <div class="col-12">

              <input type="text" class="form-control" name="title" placeholder="Title" style="background: var(--middle-color)">
            </div>

          </div>

          <div class="row">
          </div>

          <div class="row mt-2">
            <div class="col-12">
              <select class="form-select" name="category" style="background: var(--middle-color)">
                <%
                  if(categoriesArrayList!= null){
                  for (Categories category : categoriesArrayList) {
                %>
                <option value="<%=category.getId()%>"><%=category.getName()%></option>
                <% } }%>
              </select>
            </div>
          </div>

          <div class="row mt-3">

            <div class="col-12">

              <label>CONTENT </label>

            </div>

          </div>

          <div class="row mt-2">

            <div class="col-12">

              <textarea class="form-control" name="content" rows="5" placeholder="Content" style="background: var(--middle-color)"></textarea>

            </div>

          </div>


          <div class="row mt-3">

            <div class="col-12">

              <button class="button-16" role="button">Add post</button>

            </div>

          </div>

        </form>
        <% } %>
      </div>

    </div>

  </div>

</body>
</html>
