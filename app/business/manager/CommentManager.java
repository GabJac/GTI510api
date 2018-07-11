package business.manager;

import business.dao.CommentDao;
import model.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static play.mvc.Controller.session;

public class CommentManager {

    public Comment createComment(Comment comment) {
        comment.setAuthor(getUserIdFromSession());
        comment.setCreationDate(LocalDateTime.now());

        CommentDao dao = new CommentDao();
        return dao.createComment(comment);
    }

    private Integer getUserIdFromSession() {
        String userId = session().get("user");
        return userId != null ? Integer.parseInt(userId) : null;
    }
}
