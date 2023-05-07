package shop.servlets;

import shop.entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Users curr = (Users) request.getSession().getAttribute("CurrentUser");
        if(curr != null){
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        } else{
            response.sendRedirect("/login");
        }

    }
}
