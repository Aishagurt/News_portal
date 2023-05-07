<%@ page import="java.util.ArrayList" %>
<%@ page import="shop.entities.Posts" %>
<%@ page import="shop.MyUtils" %>
<%@ page import="shop.entities.Categories" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@include file="head.jsp"%>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>News portal</title>
</head>
<body>
<%@include file="navbar.jsp"%>

<% ArrayList<Posts> posts = (ArrayList<Posts>) session.getAttribute("posts");
    ArrayList<Categories> cats = (ArrayList<Categories>) session.getAttribute("categories");
%>


<div class="main-container">
    <div class="big-container">
        <div class="text-overlay">
            <h1><a href="/readnews?id=<%=posts.get(0).getId()%>" class="text-dark text-decoration-none"> <%= posts.get(0).getTitle()%> </a></h1>

            <% String content = posts.get(0).getText();
                if (content.split(" ").length > 30) {
                    content = String.join(" ", Arrays.copyOfRange(content.split(" "), 0, 30));
                    content += "...";
                }
            %>
            <p class ="news-item"> <%= content %> </p>
            <p class="small-text">Published: <%= MyUtils.format(posts.get(0).getPost_date()) %> </p>
        </div>
    </div>
    <div class="long-container">
        <h1> Categories: </h1>
        <% for(Categories c: cats){ %>
        <a href="?catid=<%= c.getId() %>"><%= c.getName() %></a>
        <hr>
        <% } %>
    </div>
    <% if(posts != null){
        for(int i = 1; i < posts.size(); i++){ %>
    <div class="small-container">
        <h2><a href="/readnews?id=<%=posts.get(i).getId()%>" class="text-dark text-decoration-none"><%= posts.get(i).getTitle() %></a></h2>
        <p class="small-text">Published: <%= MyUtils.format(posts.get(i).getPost_date()) %> </p>
    </div>
    <% }} %>
</div>
<script>
    $(document).ready(function() {
        var newsContent = $(".news-item").text().trim().split(" ").slice(0, 200).join(" ");
        $(".news-item").text(newsContent + "...");
        $(".news-item").show();
    });
</script>
</body>
</html>


