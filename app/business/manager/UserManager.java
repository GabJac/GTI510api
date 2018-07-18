package business.manager;

import business.dao.UserDao;
import model.Utilisateur;

import static play.mvc.Controller.session;

public class UserManager {

    public Utilisateur getUserFromSession() {
        Utilisateur user = null;
        String userId = session().get("user");

        if (userId != null) {
            UserDao dao = new UserDao();
            user = dao.getUser(Integer.parseInt(userId));
        }

        return user;
    }

    public Utilisateur updateUser(Utilisateur user, String userId) {
        int id = Integer.parseInt(userId);
        user.setAdmin(null);
        user.setUserId(id);
        //todo ebean user.save();

        UserDao dao = new UserDao();
        return dao.getUser(id);
    }
}
