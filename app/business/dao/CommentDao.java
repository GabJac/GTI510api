package business.dao;

import model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    public List<Comment> listCommentFromArticle(int articleId) {
        return new ArrayList<>();
    }

    public Comment createComment(Comment commentToCreate) {
        //todo commentToCreate.save();
        return null;
    }
}
