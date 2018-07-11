package model;

import java.time.LocalDateTime;

public class Comment extends AbstractModel {

    private Integer id;
    private String comment;
    private Integer author;
    private Integer previousCommentId;
    private Integer articleId;
    private LocalDateTime creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getPreviousCommentId() {
        return previousCommentId;
    }

    public void setPreviousCommentId(Integer previousCommentId) {
        this.previousCommentId = previousCommentId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
