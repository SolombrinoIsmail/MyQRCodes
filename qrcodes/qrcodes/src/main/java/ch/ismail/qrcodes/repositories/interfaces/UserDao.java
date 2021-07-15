package ch.ismail.qrcodes.repositories.interfaces;

import ch.ismail.qrcodes.models.User;

import java.util.List;


public interface UserDao {
    List<User> get();

    User get(long id);

    void save(User user);

    void delete(long id);

}
