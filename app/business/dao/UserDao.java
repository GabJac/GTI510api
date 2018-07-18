package business.dao;

import model.Utilisateur;

public class UserDao {

    public Utilisateur getUserFromUsername(String username) {
        return Utilisateur.find.query().where().eq("email", username).findOne();
    }

    public Utilisateur getUser(int userId) {
        return Utilisateur.find.byId(Long.valueOf(userId));
    }
}
