<%@ page import="shop.entities.Posts" %>
<%@ page import="shop.MyUtils" %>
<%@ page import="shop.entities.Comments" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <%@include file="head.jsp"%>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>

<%@include file="navbar.jsp"%>

<div class="container" style="min-height: 500px;">

    <%

        Posts post = (Posts) session.getAttribute("post");

        if(post!=null){

    %>

<%--    <% if(Objects.equals(curr.getRole_id(), "1")){ %>--%>

<%--    <form action = "/post" method="post">--%>

<%--        <input type="hidden" name="news_id" value="<%=post.getId()%>">--%>

<%--        <button class="button-16" role="button" style="margin-top: 20px">Change post</button>--%>

<%--    </form>--%>

<%--    <% } %>--%>

    <div class="row mt-3">

        <div class="col-12">



            <div class="row mt-3">
                <% if(curr != null){ if(Objects.equals(curr.getRole_id(), "1")){ %>
                <div class="for-post">

                    <button type="button" class="btn btn-warning" style="margin-left: 40px; display: inline-block;">
                        <a href="/post?id=<%=post.getId()%>" class="text-dark text-decoration-none">
                            Edit post
                        </a>
                    </button>

                    <form id="delete-form" action="/deletepost" method="post" style="display: inline-block;">
                        <input type="hidden" name="postId" value="<%=post.getId()%>">
                        <button type="button" onclick="confirmDelete()" class="btn btn-danger" >Delete post</button>
                    </form>



                </div>
                <% }} %>
                <div class="col-11 mx-auto p-3" style="background-color: lightgrey; margin-top: 20px;">

                    <h2><%=post.getTitle()%></h2>

                    <p class="mt-2"><%=post.getText()%></p>

                    <h6 class="mt-2">Published: <%= MyUtils.format(post.getPost_date()) %></h6>

                    <%

                        if(curr!=null){

                    %>

                    <div class="row mt-2">

                        <div class="col-12">

                            <form action="/addcomment" method="post">

                                <input type="hidden" name="news_id" value="<%=post.getId()%>">

                                <textarea class="form-control" name="comment" placeholder="Write a comment"></textarea>

                                <button class="button-16" role="button" style="margin-top: 20px">Add comment</button>

                            </form>

                        </div>

                    </div>

                    <%

                        }

                    %>

                </div>

            </div>


            <hr>

            <%

                ArrayList<Comments> comments = (ArrayList<Comments>) session.getAttribute("comments");

                if(comments!=null){

                    for(Comments comment : comments){

            %>


                    <div class="comment">
                    <h5><%=comment.getUser().getFullName()%>
                        <form action="/deletecomment" method="post" style="display: inline-block; height: auto;">
                        <% if(curr!= null){ if(Objects.equals(curr.getRole_id(), "1")){ %>
                            <input type="hidden" name="comid" value="<%=comment.getId()%>">
                            <input type="hidden" name="newsid" value="<%=post.getId()%>">
                            <button type="submit" class="button-16" style="color: #202124">x</button>
                        </form>
                        <% }} %>
                    </h5>
                    <p><%=comment.getComment()%></p>

                    <h6>Posted <strong><%= MyUtils.format(comment.getPostDate()) %></strong></h6>
                    </div>
            <hr>
            <%

                    }

                }

            %>


            <%

                }

            %>

        </div>

    </div>

</div>

</body>
<script>
    function confirmDelete() {
        var result = confirm("Are you sure you want to delete this post?");
        if (result) {
            document.getElementById("delete-form").submit();
        }
    }
</script>

</html>

