package controllers;

import business.dao.CommentDao;
import business.manager.CommentManager;
import io.ebean.Ebean;
import model.Comments;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Result;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

public class CommentController extends AbstractController {

    private final FormFactory formFactory;

    @Inject
    public CommentController(FormFactory formFactory) {
        super(Comments.class);
        this.formFactory = formFactory;
    }

    public Result getArticleComment(String aticleId) {
        CommentDao dao = new CommentDao();
        List<Comments> comments = dao.listCommentFromArticle(Integer.parseInt(aticleId));

        return ok(getJsonFromModels(comments));
    }

    public Result createComment() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        Comments comment = new Comments();
        comment.setCreationDate(LocalDateTime.now());

        String articleId = requestData.get("articleId");
        if (articleId != null) {
            comment.setArticleId(Integer.parseInt(articleId));
        }
        comment.setComments(requestData.get("comment"));

        String id = session().get("user");
        if(id != null) {
            comment.setUserId(Integer.parseInt(id));
        }

        Ebean.save(comment);
        return redirect(routes.ArticleController.showArticle(articleId));
    }

    public Result createReply(String articleId, String commentId) {
        Comments comment = (Comments) getModelFromJson();
        comment.setArticleId(Integer.parseInt(articleId));
        comment.setPreviousCommentId(Integer.parseInt(commentId));
        CommentManager manager = new CommentManager();
        Comments createdComment = manager.createComment(comment);

        return ok(getJsonFromModel(createdComment));
    }
}
