package ch.ismail.qrcodes.repositories.implementations;

import ch.ismail.qrcodes.models.User;

import java.util.List;
import javax.persistence.EntityManager;

import ch.ismail.qrcodes.repositories.interfaces.UserDao;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImp implements UserDao {


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> get() {
        String hql = "FROM User";
        Session currSession = entityManager.unwrap(Session.class);
        Query<User> query = currSession.createQuery(hql, User.class);
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public User get(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        User user = currSession.get(User.class, id);
        return user;
    }

    @Override
    public void save(User user) {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(user);
    }

    @Override
    public void delete(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        User user = currSession.get(User.class, id);
        currSession.delete(user);
    }
}
