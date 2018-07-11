package controllers;

import business.dao.CommentDao;
import business.manager.CommentManager;
import model.Comment;
import play.mvc.Result;

import java.util.List;

public class CommentController extends AbstractController {

    public CommentController() {
        super(Comment.class);
    }

    public Result getArticleComment(String aticleId) {
        CommentDao dao = new CommentDao();
        List<Comment> comments = dao.listCommentFromArticle(Integer.parseInt(aticleId));

        return ok(getJsonFromModels(comments));
    }

    public Result createComment(String articleId) {
        Comment comment = (Comment) getModelFromJson();
        comment.setArticleId(Integer.parseInt(articleId));
        CommentManager manager = new CommentManager();
        Comment createdComment = manager.createComment(comment);

        return ok(getJsonFromModel(createdComment));
    }

    public Result createReply(String articleId, String commentId) {
        Comment comment = (Comment) getModelFromJson();
        comment.setArticleId(Integer.parseInt(articleId));
        comment.setPreviousCommentId(Integer.parseInt(commentId));
        CommentManager manager = new CommentManager();
        Comment createdComment = manager.createComment(comment);

        return ok(getJsonFromModel(createdComment));
    }
}
