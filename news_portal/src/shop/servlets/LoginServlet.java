package shop.servlets;

import shop.db.DBManager;
import shop.entities.Categories;
import shop.entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,   HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Users user = DBManager.getUser(email);
        if(user!= null && Objects.equals(user.getPassword(), password)){
            HttpSession session = request.getSession();
            session.setAttribute("CurrentUser", user);
            response.sendRedirect("/profile");
        } else{
            response.sendRedirect("/login?error");
        }
    }
}
