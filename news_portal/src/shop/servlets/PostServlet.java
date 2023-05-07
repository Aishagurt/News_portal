package shop.servlets;

import shop.db.DBManager;
import shop.entities.Categories;
import shop.entities.Posts;
import shop.entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(value = "/post")
public class PostServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        if(request.getParameter("id") != null){
            Long id = Long.parseLong(request.getParameter("id"));
            Posts post = DBManager.getPost(id);
            if(post!= null){
                request.getSession().setAttribute("post", post);
                request.setAttribute("textareaValue", post.getText());
            }
        }

        ArrayList<Categories> categoriesArrayList = DBManager.getAllCategories();
        request.getSession().setAttribute("categories", categoriesArrayList);
        request.getRequestDispatcher("/post.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String title = request.getParameter("title");
        String text = request.getParameter("content");
        Long categoryId = Long.parseLong(request.getParameter("category"));
        Timestamp post_date = Timestamp.valueOf(LocalDateTime.now());
        if(!Objects.equals(title, "") && !Objects.equals(text, "")){
            DBManager.addPost(new Posts(null, categoryId, title, text, post_date));
            response.sendRedirect("post.jsp?success=true");
        } else{
            response.sendRedirect("post.jsp?error=true");
        }

    }
}
