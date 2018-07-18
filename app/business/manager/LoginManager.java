package business.manager;

import business.dao.UserDao;
import model.Utilisateur;

import static play.mvc.Controller.session;

public class LoginManager {

    public boolean login(Utilisateur user) {
        logout();

        if (user != null && user.getEmail() != null) {
            UserDao dao = new UserDao();
            Utilisateur realUser = dao.getUserFromUsername(user.getEmail());

            if (realUser == null || !realUser.getPassword().equals(user.getPassword())) {
                return false;
            }

            setSession(realUser.getUserId());
        } else {
            return false;
        }
        return true;
    }

    private void setSession(int id) {
        session().put("user", String.valueOf(id));
    }

    public void logout() {
        session().clear();
    }
}
