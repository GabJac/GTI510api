package controllers;

import business.manager.LoginManager;
import model.User;
import play.data.FormFactory;
import play.mvc.*;
import views.html.login;

import javax.inject.Inject;

public class LoginController extends AbstractController {

    private final FormFactory formFactory;

    @Inject
    public LoginController(FormFactory formFactory) {
        super(User.class);
        this.formFactory = formFactory;
    }

    public Result login() {
        User user = (User) getModelFromJson();

        LoginManager loginManager = new LoginManager();
        loginManager.login(user);

        return ok(login.render());
    }

    public Result logout() {
        LoginManager loginManager = new LoginManager();
        loginManager.logout();

        return ok();
    }

    public Result getLoginPage() {
        return ok(login.render());
    }
}
