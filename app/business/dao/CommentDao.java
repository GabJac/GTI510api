package business.dao;

import model.Comments;

import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    public List<Comments> listCommentFromArticle(int articleId) {
        return Comments.find.query().where().eq("article_id", articleId).findList();
    }

    public Comments createComment(Comments commentToCreate) {
        //todo commentToCreate.save();
        return null;
    }
}
