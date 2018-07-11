package business.manager;

import business.dao.UserDao;
import model.User;

import static play.mvc.Controller.session;

public class LoginManager {

    public void login(User user) {
        logout();

        if (user != null) {
            UserDao dao = new UserDao();
            User realUser = dao.getUserFromUsername(user.getUsername());

            if (realUser == null || !realUser.getPassword().equals(user.getPassword())) {
                throw new RuntimeException("Wrong username or password");
            }

            setSession(realUser.getId());
        } else {
            throw new RuntimeException("Wrong username or password");
        }

    }

    private void setSession(int id) {
        session().put("user", String.valueOf(id));
    }

    public void logout() {
        session().clear();
    }
}
