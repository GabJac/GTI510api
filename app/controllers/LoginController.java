package controllers;

import business.manager.LoginManager;
import model.Utilisateur;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;
import views.html.article;
import views.html.login;

import javax.inject.Inject;

public class LoginController extends AbstractController {

    private final FormFactory formFactory;

    @Inject
    public LoginController(FormFactory formFactory) {
        super(Utilisateur.class);
        this.formFactory = formFactory;
    }

    public Result login() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        Utilisateur user = new Utilisateur();
        user.setEmail(requestData.get("email"));
        user.setPassword(requestData.get("password"));

        LoginManager loginManager = new LoginManager();

        if (!loginManager.login(user)) {
            return ok(login.render(true));
        }

        return redirect(routes.ArticleController.article());
    }

    public Result logout() {
        LoginManager loginManager = new LoginManager();
        loginManager.logout();

        return ok(login.render(false));
    }

    public Result getLoginPage() {
        return ok(login.render(false));
    }
}
