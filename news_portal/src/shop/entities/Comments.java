package shop.entities;

import java.sql.Timestamp;

public class Comments {

    private Long id;

    private Users user;

    private Posts post;

    private String comment;

    private Timestamp postDate;



    public Comments(){
    }



    public Comments(Long id, Users user, Posts post, String comment, Timestamp postDate) {

        this.id = id;

        this.user = user;

        this.post = post;

        this.comment = comment;

        this.postDate = postDate;

    }



    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public Users getUser() {

        return user;

    }

    public void setUser(Users user) {

        this.user = user;

    }

    public Posts getPost() {

        return post;

    }

    public void setPost(Posts post) {

        this.post = post;

    }

    public String getComment() {

        return comment;

    }

    public void setComment(String comment) {

        this.comment = comment;

    }

    public Timestamp getPostDate() {

        return postDate;

    }

    public void setPostDate(Timestamp postDate) {

        this.postDate = postDate;

    }

}