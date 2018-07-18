package controllers;

import business.dao.UserDao;
import business.manager.PermissionManager;
import business.manager.UserManager;
import io.ebean.Ebean;
import model.Utilisateur;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Result;
import views.html.login;
import views.html.profile;
import views.html.register;

import javax.inject.Inject;

public class UserController extends AbstractController {

    private final FormFactory formFactory;

    @Inject
    public UserController(FormFactory formFactory) {
        super(Utilisateur.class);
        this.formFactory = formFactory;
    }

    public Result getUserInfo() {
        PermissionManager.checkBasicPermission();
        UserManager userManager = new UserManager();
        Utilisateur user = userManager.getUserFromSession();

        return ok(getJsonFromModel(user));
    }

    public Result updateUser() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String userId = session().get("user");

        UserDao dao = new UserDao();
        Utilisateur user = dao.getUser(Integer.parseInt(userId));

        String email = requestData.get("email");
        if(email != null && !email.equals("")) {
            user.setEmail(email);
        }

        String firstName = requestData.get("firstName");
        if (firstName != null && !firstName.equals("")) {
            user.setPrenom(firstName);
        }

        String lastName = requestData.get("lastName");
        if(lastName != null && !lastName.equals("")) {
            user.setNom(lastName);
        }

        String password = requestData.get("password");
        if(password != null && !password.equals("")) {
            user.setPassword(password);
        }

        Ebean.update(user);

        user = dao.getUser(Integer.parseInt(userId));
        return ok(profile.render(user, true));
    }

    public Result register() {
        return ok(register.render(false, session().get("user") != null));
    }

    public Result profile() {
        String id = session().get("user");
        if(id == null) {
            return ok(login.render(false));
        }

        UserDao dao = new UserDao();
        Utilisateur user = dao.getUser(Integer.parseInt(id));

        if(user == null) {
            ok(login.render(false));
        }

        return ok(profile.render(user, false));
    }

    public Result createUser() throws Exception {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdmin(false);
        utilisateur.setEmail(requestData.get("email"));
        utilisateur.setPrenom(requestData.get("firstName"));
        utilisateur.setNom(requestData.get("lastName"));
        utilisateur.setPassword(requestData.get("password"));

        if ((utilisateur.getEmail() == null || utilisateur.getEmail().equals("")) ||
                (utilisateur.getPassword() == null || utilisateur.getPassword().equals("")) ||
                (utilisateur.getPrenom() == null || utilisateur.getPrenom().equals(""))
                || (utilisateur.getNom() == null) || utilisateur.getNom().equals("")) {
            return ok(register.render(true, session().get("user") != null));
        }

        try {
            Ebean.save(utilisateur);
        } catch (Error e) {
            return ok(register.render(true, session().get("user") != null));
        }

        return ok(login.render(false));
    }

}
