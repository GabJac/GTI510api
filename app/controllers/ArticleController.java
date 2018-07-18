package controllers;

import business.dao.ArticleDao;
import business.manager.PermissionManager;
import model.Article;
import play.mvc.Result;
import views.html.article;

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
        Article ar = new Article();
        ar.setId(1);
        ar.setTitle("Oh.. Wow");
        ar.setText("Dum apud Persas, ut supra narravimus, perfidia regis motus agitat insperatos, et in eois tractibus bella rediviva consurgunt, anno sexto decimo et eo diutius post Nepotiani exitium, saeviens per urbem aeternam urebat cuncta Bellona, ex primordiis minimis ad clades excita luctuosas, quas obliterasset utinam iuge silentium! ne forte paria quandoque temptentur, plus exemplis generalibus nocitura quam delictis.\n" +
                "\n" +
                "Dein Syria per speciosam interpatet diffusa planitiem. hanc nobilitat Antiochia, mundo cognita civitas, cui non certaverit alia advecticiis ita adfluere copiis et internis, et Laodicia et Apamia itidemque Seleucia iam inde a primis auspiciis florentissimae...");

       List<Article> articles = new ArrayList<>();
       articles.add(ar);
       articles.add(ar);
       articles.add(ar);
       articles.add(ar);
       articles.add(ar);
       articles.add(ar);
       articles.add(ar);
        return ok(article.render(articles, session().get("user") != null));
    }

    public Result showArticle(String id) {
        return ok(article.render(new ArrayList<>(), session().get("user") != null));
    }
}
