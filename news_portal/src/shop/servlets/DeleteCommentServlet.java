package shop.servlets;

import shop.entities.Comments;
import shop.entities.Posts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import shop.db.DBManager;

@WebServlet(value = "/deletecomment")
public class DeleteCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long commid = Long.parseLong(request.getParameter("comid"));
        Long postid = Long.parseLong(request.getParameter("newsid"));
        ArrayList<Comments> comms = DBManager.getAllComments(postid);

        if(comms!=null){
            for(Comments c: comms) {
                if(commid.equals(c.getId())){
                    DBManager.deleteComment(commid);
                }
            }

        }

        response.sendRedirect("/readnews?id=" + postid);

    }
}
