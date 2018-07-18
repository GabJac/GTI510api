package business.manager;

import business.dao.UserDao;
import model.Utilisateur;

import java.util.Objects;

import static play.mvc.Controller.session;

public class PermissionManager {

    public static boolean checkBasicPermission() {
        if (session().get("user") == null) {
            throw new RuntimeException("Not connected");
        }

        return true;
    }

    public static boolean checkAdminPermission() {
        String userId = session().get("user");

        if (userId == null) {
            throw new RuntimeException("Not connected");
        }

        UserDao dao = new UserDao();
        Utilisateur user = dao.getUser(Integer.parseInt(userId));

        if (!user.getStatut().equals("admin")) {
            throw new RuntimeException("Cannot do that!!!!!!!");
        }

        return true;
    }

    public static void checkUpdateUserPermission(String userId) {
        if (!Objects.equals(userId, session().get("user"))) {
            checkAdminPermission();
        }
    }
}
