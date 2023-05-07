package shop.servlets;
import shop.db.DBManager;
import shop.entities.Categories;
import shop.entities.Posts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.ArrayList;


@WebServlet(value = "/home")

public class HomeServlet extends HttpServlet {



    @Override

    protected void doPost(HttpServletRequest request,

                          HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/home");
    }



    @Override

    protected void doGet(HttpServletRequest request,

                         HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Categories> categoriesArrayList = DBManager.getAllCategories();
        request.getSession().setAttribute("categories", categoriesArrayList);

        String catidstr = request.getParameter("catid");
        if (catidstr == null || catidstr.isEmpty()) {
            ArrayList<Posts> posts = DBManager.getAllPosts();
            request.getSession().setAttribute("posts", posts);
        } else {
            long catid = Long.parseLong(catidstr);
            ArrayList<Posts> posts = DBManager.getAllPostsbycat(catid);
            request.getSession().setAttribute("posts", posts);
        }

        request.getRequestDispatcher("home.jsp").forward(request, response);

        request.getRequestDispatcher("/home.jsp").forward(request, response);

    }

}