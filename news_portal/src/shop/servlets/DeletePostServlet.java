package shop.servlets;

import shop.entities.Posts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import shop.db.DBManager;

@WebServlet(value = "/deletepost")
public class DeletePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("postId"));

        Posts post = DBManager.getPost(id);

        if(post!=null){

            DBManager.detelePost(id);

        }


    }
}
