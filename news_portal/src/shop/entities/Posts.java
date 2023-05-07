package shop.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Posts {
    Long id;
    Timestamp post_date;
    Long cat_id;
    String title;
    String text;
    public Posts(){
    }
    public Posts(Long id, Long cat_id, String title, String text, Timestamp post_date) {
        this.id = id;
        this.post_date = post_date;
        this.cat_id = cat_id;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
