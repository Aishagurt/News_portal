package shop.servlets;

import shop.entities.Posts;
import shop.entities.Comments;
import shop.entities.Users;
import shop.db.DBManager;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;



@WebServlet(value = "/addcomment")

public class AddCommentServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        String redirect = "/login";

        request.setCharacterEncoding("utf8");

        Users currentUser = (Users) request.getSession().getAttribute("CurrentUser");

        if(currentUser!=null) {

            String commentText = request.getParameter("comment");

            Long newsId = Long.parseLong(request.getParameter("news_id"));

            Posts news = DBManager.getPost(newsId);

            if(news!=null){

                Comments comment = new Comments();

                comment.setComment(commentText);

                comment.setUser(currentUser);

                comment.setPost(news);

                if(DBManager.addComment(comment)){

                    redirect = "/readnews?id="+newsId;

                }

            }

        }

        response.sendRedirect(redirect);

    }

}