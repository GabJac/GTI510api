package controllers;

import business.dao.ArticleDao;
import business.dao.CommentDao;
import business.dao.UserDao;
import business.manager.ArticleUtils;
import business.manager.PermissionManager;
import model.Article;
import model.Comments;
import model.Utilisateur;
import play.mvc.Result;
import views.html.article;
import views.html.completeArticle;

import java.util.ArrayList;
import java.util.List;

public class ArticleController extends AbstractController {

    public ArticleController() {
        super(Article.class);
    }

    public Result listArticles() {
        ArticleDao dao = new ArticleDao();
        List<Article> articles = dao.listAll();
        return ok(getJsonFromModels(articles));
    }

    public Result createArticle() {
        PermissionManager.checkAdminPermission();
        Article article = (Article) getModelFromJson();
        ArticleDao dao = new ArticleDao();
        Article createArticle = dao.createArticle(article);

        return ok(getJsonFromModel(createArticle));
    }

    public Result article() {
        return ok(article.render(new ArrayList<>(ArticleUtils.articles.values()), session().get("user") != null));
    }

    public Result showArticle(String id) {
       Article ar = ArticleUtils.articles.get(Integer.parseInt(id));

        CommentDao commentDao = new CommentDao();
        List<Comments> comments = commentDao.listCommentFromArticle(Integer.parseInt(id));

        UserDao dao = new UserDao();
        comments.stream().forEach(c -> {
            if (c.getUserId() != null) {
                Utilisateur user = dao.getUser(c.getUserId());
                c.setUserName(user.getPrenom() + " " + user.getNom());
            }
        });

        return ok(completeArticle.render(ar, session().get("user") != null, comments));
    }
}
