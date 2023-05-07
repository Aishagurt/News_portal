package shop.servlets;

import shop.db.DBManager;

import shop.entities.Users;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;



@WebServlet(value = "/register")

public class AddUserServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
        String previousInput = request.getParameter("textInput");
        request.setAttribute("previousInput", previousInput);

        request.getRequestDispatcher("/register.jsp").forward(request, response);

    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        String redirect = "/register?emailerror";

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        String rePassword = request.getParameter("re_password");

        String fullName = request.getParameter("full_name");

        Users checkUser = DBManager.getUser(email);

        if(checkUser==null){ //Проверяем, если пользователя с таким email не существует

            redirect = "/register?passworderror";

            if(password.equals(rePassword)){

                Users user = new Users();

                user.setEmail(email);

                user.setPassword(password);

                user.setFullName(fullName);

                if(DBManager.addUser(user)){

                    redirect = "/register?success";

                }

            }

        }

        response.sendRedirect(redirect);

    }

}