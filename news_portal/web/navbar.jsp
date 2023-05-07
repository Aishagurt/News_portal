<%@ page import="shop.entities.Users" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<%
    Users curr = (Users) session.getAttribute("CurrentUser");

%>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background: #FEEAE6">
    <div class="container-fluid" style="background: #FEEAE6">
        <a class="navbar-brand" href="/home">News portal</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">News</a>
                </li>
                <% if(curr != null){

                %>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Profile</a>
                </li>
                <%
                    }
                %>
                <%
                    if(curr != null && curr.getRole_id().equals("1")){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/post">Add post</a>
                </li>
                <% } %>
            </ul>
<%--            <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="margin-left: 400px">--%>
<%--                <form class="d-flex" role="search">--%>
<%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                    <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--                </form>--%>
<%--            </ul>--%>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="margin-left: 800px">
                <%
                    if(curr != null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/signout">Sign out</a>
                </li>
                <% } %>
            <li class="nav-item">
                <a class="nav-link" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false", id="theme">
                    <img src="/static/night_icon.png" alt="Small Container Image" style="width: 30px; height: 30px" id="dark_icon">
                </a>
            </li>
                <% if(curr == null){
                    %>

                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>

                <%

                }
                    %>

            </ul>
        </div>
    </div>
</nav>
<script>
    var dark = document.getElementById('theme');
    var icon = document.getElementById('dark_icon');

    dark.onclick = function() {
        document.body.classList.toggle('dark-theme');
        if (icon.getAttribute('src') === '/static/night_icon.png') {
            icon.setAttribute('src', '/static/day_icon.png');
            document.cookie = 'theme=day;path=/';
        } else {
            icon.setAttribute('src', '/static/night_icon.png');
            document.cookie = 'theme=night;path=/';
        }
    }

    function getCookie(name) {
        var value = "; " + document.cookie;
        var parts = value.split("; " + name + "=");
        if (parts.length === 2) {
            return parts.pop().split(";").shift();
        }
    }

    var savedTheme = getCookie('theme');
    if (savedTheme === 'day') {
        document.body.classList.add('dark-theme');
        icon.setAttribute('src', '/static/day_icon.png');
    } else if (savedTheme === 'night') {
        document.body.classList.remove('dark-theme');
        icon.setAttribute('src', '/static/night_icon.png');
    }
</script>
