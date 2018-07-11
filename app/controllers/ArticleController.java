package controllers;

import business.dao.ArticleDao;
import business.manager.PermissionManager;
import model.Article;
import play.mvc.Result;
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

}
