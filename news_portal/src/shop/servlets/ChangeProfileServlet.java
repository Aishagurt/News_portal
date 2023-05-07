package shop.servlets;

import shop.db.DBManager;
import shop.entities.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/editprofile")
public class ChangeProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users user = (Users) request.getSession().getAttribute("CurrentUser");
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(password);
        DBManager.updateUser(user);
        response.sendRedirect("/profile?id=" + user.getId());
    }
}
