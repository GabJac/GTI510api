package controllers;

import business.manager.PermissionManager;
import business.manager.UserManager;
import model.User;
import play.mvc.Result;
import views.html.profile;
import views.html.register;

public class UserController extends AbstractController {

    public UserController() {
        super(User.class);
    }

    public Result getUserInfo() {
        PermissionManager.checkBasicPermission();
        UserManager userManager = new UserManager();
        User user = userManager.getUserFromSession();

        return ok(getJsonFromModel(user));
    }

    public Result updateUser(String userId) {
        PermissionManager.checkUpdateUserPermission(userId);
        User user = (User) getModelFromJson();
        UserManager userManager = new UserManager();
        User updatedUser = userManager.updateUser(user, userId);

        return ok(getJsonFromModel(updatedUser));
    }

    public Result register() {
        return ok(register.render());
    }

    public Result profile() {
        return ok(profile.render());
    }

}
