package shop.servlets;


import shop.entities.Comments;
import shop.entities.Posts;
import shop.db.DBManager;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/readnews")

public class NewsDetailsServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Posts post = DBManager.getPost(id);

        if(post!=null){

            ArrayList<Comments> comments = DBManager.getAllComments(post.getId());
            request.getSession().setAttribute("comments", comments);

        }

        request.getSession().setAttribute("post", post);

        request.getRequestDispatcher("/newsdetails.jsp").forward(request, response);

    }

}
