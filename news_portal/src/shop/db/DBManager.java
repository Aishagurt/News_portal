package shop.db;

import shop.entities.Categories;
import shop.entities.Comments;
import shop.entities.Posts;
import shop.entities.Users;

import java.sql.*;

import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/bitlab_test?useUnicode=true&serverTimezone=UTC", "root", ""

            );

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static boolean addUser(Users user) {

        try {

            PreparedStatement statement = connection.prepareStatement("" +

                    "INSERT INTO users (id, email, password, fullname, role_id) " +

                    "VALUES (NULL, ?, ?, ?, ?)"

            );

            statement.setString(1, user.getEmail());

            statement.setString(2, user.getPassword());

            statement.setString(3, user.getFullName());

            statement.setString(4, "0");

            int rows = statement.executeUpdate();

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

        return true;
    }

    public static ArrayList<Users> getAllUsers() {

        ArrayList<Users> usersList = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Long id = resultSet.getLong("id");

                String email = resultSet.getString("email");

                String password = resultSet.getString("password");

                String fullname = resultSet.getString("fullname");

                String role_id = resultSet.getString("role_id");

                usersList.add(new Users(id, email, password, fullname, role_id));

            }

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return usersList;

    }

    public static Users getUser(Long id) {

        Users user = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                String email = resultSet.getString("email");

                String password = resultSet.getString("password");

                String fullname = resultSet.getString("fullname");

                String role_id = resultSet.getString("role_id");

                user = new Users(id, email, password, fullname, role_id);

            }

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return user;
    }
    public static Users getUser(String email) {

        Users user = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Long id = resultSet.getLong("id");

                String password = resultSet.getString("password");

                String fullname = resultSet.getString("fullname");

                String role_id = resultSet.getString("role_id");

                user = new Users(id, email, password, fullname, role_id);

            }

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return user;
    }

    public static void updateUser(Users user) {

        try {

            PreparedStatement statement = connection.prepareStatement("" +

                    "UPDATE users SET email = ?, password = ?, fullname = ?, role_id = ? " +

                    "WHERE id = ?");

            statement.setString(1, user.getEmail());

            statement.setString(2, user.getPassword());

            statement.setString(3, user.getFullName());

            statement.setString(4, user.getRole_id());

            statement.setLong(5, user.getId());

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public static void addPost(Posts post){
        try{
            PreparedStatement statement = connection.prepareStatement("" +

                "INSERT INTO posts (id, post_date, cat_id, title, text) " +

                "VALUES (NULL, ?, ?, ?, ?)"

        );

        statement.setTimestamp(1, post.getPost_date());

        statement.setLong(2, post.getCat_id());

        statement.setString(3, post.getTitle());

        statement.setString(4, post.getText());

        int rows = statement.executeUpdate();

        statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Posts> getAllPosts() {

        ArrayList<Posts> postsArrayList = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts ORDER BY post_date DESC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Long id = resultSet.getLong("id");

                Long cat_id = resultSet.getLong("cat_id");

                String title = resultSet.getString("title");

                String text = resultSet.getString("text");

                Timestamp post_date = resultSet.getTimestamp("post_date");

                postsArrayList.add(new Posts(id, cat_id, title, text, post_date));

            }

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return postsArrayList;

    }
    public static ArrayList<Posts> getAllPostsbycat(Long categoryId) {

        ArrayList<Posts> postsArrayList = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts WHERE cat_id = ? ORDER BY post_date DESC");

            statement.setLong(1, categoryId);

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {

                Long id = resultSet.getLong("id");

                String title = resultSet.getString("title");

                String text = resultSet.getString("text");

                Timestamp post_date = resultSet.getTimestamp("post_date");

                postsArrayList.add(new Posts(id, categoryId, title, text, post_date));

            }

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return postsArrayList;

    }
    public static Posts getPost(Long id) {

        Posts post = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Long cat_id = resultSet.getLong("cat_id");

                String title = resultSet.getString("title");

                String text = resultSet.getString("text");

                Timestamp post_date = resultSet.getTimestamp("post_date");

                post = new Posts(id, cat_id, title, text, post_date);

            }

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return post;
    }
    public static void updatePost(Posts post) {

        try {

            PreparedStatement statement = connection.prepareStatement("" +

                    "UPDATE posts SET post_date = ?, cat_id = ?, title = ?, text = ? " +

                    "WHERE id = ?");

            statement.setTimestamp(1, post.getPost_date());

            statement.setLong(2, post.getCat_id());

            statement.setString(3, post.getTitle());

            statement.setString(3, post.getText());

            statement.setLong(4, post.getId());

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public static void detelePost(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM posts WHERE id = ?");

            statement.setLong(1, id);

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

    }
    public static ArrayList<Categories> getAllCategories() {

        ArrayList<Categories> categoriesArrayList = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Long id = resultSet.getLong("id");

                String name = resultSet.getString("name");

                categoriesArrayList.add(new Categories(id, name));

            }

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return categoriesArrayList;

    }

    public static boolean addComment(Comments comment){

        int rows = 0;

        try{

            PreparedStatement statement = connection.prepareStatement("" +

                    "INSERT INTO comments (user_id, news_id, comment, post_date) " +

                    "VALUES (?, ?, ?, NOW())");



            statement.setLong(1, comment.getUser().getId());

            statement.setLong(2, comment.getPost().getId());

            statement.setString(3, comment.getComment());



            rows = statement.executeUpdate();

            statement.close();



        }catch (Exception e){

            e.printStackTrace();

        }

        return rows>0;

    }



    public static ArrayList<Comments> getAllComments(Long newsId){

        ArrayList<Comments> comments = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +

                    "SELECT c.id, c.user_id, c.comment, c.news_id, u.fullname, u.email, c.post_date " +

                    "FROM comments c " +

                    "INNER JOIN users u ON c.user_id = u.id " +

                    "WHERE c.news_id = ? " +

                    "ORDER BY c.post_date DESC");

            statement.setLong(1, newsId);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){



                Comments comment = new Comments();

                comment.setId(resultSet.getLong("id"));

                comment.setComment(resultSet.getString("comment"));

                comment.setPostDate(resultSet.getTimestamp("post_date"));



                Users user = new Users();

                user.setId(resultSet.getLong("user_id"));

                user.setFullName(resultSet.getString("fullname"));

                user.setEmail(resultSet.getString("email"));

                comment.setUser(user);



                Posts post = new Posts();

                post.setId(resultSet.getLong("news_id"));

                comment.setPost(post);



                comments.add(comment);

            }

            statement.close();



        }catch (Exception e){

            e.printStackTrace();

        }

        return comments;

    }
    public static void deleteComment(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM comments WHERE id = ?");

            statement.setLong(1, id);

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

}


// post show date properly with number of comment + profile info + settings (should move it to profile settings)
// search + divide by category + page for seeing news and publish comments


// im tired ffs, finish newsdetails so by clickin on news you get on its own page + infinity scrolling and other shit