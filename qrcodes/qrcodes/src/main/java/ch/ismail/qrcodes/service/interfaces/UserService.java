package ch.ismail.qrcodes.service.interfaces;

import ch.ismail.qrcodes.models.User;

import java.util.List;

public interface UserService {
    List<User> get();

    User get(long id);

    void save(User employee);

    void delete(long id);
}
