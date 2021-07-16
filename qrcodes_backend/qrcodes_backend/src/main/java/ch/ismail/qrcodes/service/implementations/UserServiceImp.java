package ch.ismail.qrcodes.service.implementations;

import ch.ismail.qrcodes.models.User;
import ch.ismail.qrcodes.repositories.interfaces.UserDao;
import ch.ismail.qrcodes.service.interfaces.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public List<User> get() {
        return userDao.get();
    }

    @Transactional
    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Transactional
    @Override
    public void save(User employee) {
        userDao.save(employee);

    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
