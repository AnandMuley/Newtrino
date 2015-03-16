package newtrino.daos;

import newtrino.beans.User;

public interface UserDao {

    void create(User user);

    int delete(String userId);

    User find(String username,String password);

    User findById(String userId);

}
