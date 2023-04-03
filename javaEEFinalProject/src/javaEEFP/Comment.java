package javaEEFP;

import java.sql.Timestamp;

public class Comment {
    private Long id;
    private String comment;
    private Timestamp post_date;
    private User userComment; // это тут указываем, вместо  user_id - int  //автор комментария
    private News newsComment; // это вместо news_id - int

    public Comment() {
    }

    public Comment(Long id, String comment, Timestamp post_date, User userComment, News newsComment) {
        this.id = id;
        this.comment = comment;
        this.post_date = post_date;
        this.userComment = userComment;
        this.newsComment = newsComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public User getUserComment() {
        return userComment;
    }

    public void setUserComment(User userComment) {
        this.userComment = userComment;
    }

    public News getNewsComment() {
        return newsComment;
    }

    public void setNewsComment(News newsComment) {
        this.newsComment = newsComment;
    }
}
