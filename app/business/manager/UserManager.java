package business.manager;

import business.dao.UserDao;
import model.User;

import static play.mvc.Controller.session;

public class UserManager {

    public User getUserFromSession() {
        User user = null;
        String userId = session().get("user");

        if (userId != null) {
            UserDao dao = new UserDao();
            user = dao.getUser(Integer.parseInt(userId));
        }

        return user;
    }

    public User updateUser(User user, String userId) {
        int id = Integer.parseInt(userId);
        user.setAdmin(null);
        user.setId(id);
        //todo ebean user.save();

        UserDao dao = new UserDao();
        return dao.getUser(id);
    }
}
