package model;

import io.ebean.Finder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Comments extends AbstractModel {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
    private Integer id;
    private String comments;
    private Integer userId;
    private Integer previousCommentId;
    private Integer articleId;
    private LocalDateTime creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPreviousCommentId() {
        return previousCommentId;
    }

    public void setPreviousCommentId(Integer previousCommentId) {
        this.previousCommentId = previousCommentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public static final Finder<Long, Comments> find = new Finder<>(Comments.class);
}
