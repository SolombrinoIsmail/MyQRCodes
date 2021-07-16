package ch.ismail.qrcodes.repositories.implementations;

import ch.ismail.qrcodes.models.QRCode;
import ch.ismail.qrcodes.repositories.interfaces.QRCodeDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class QRCodeDAOImp implements QRCodeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List get() {
        String hql = "FROM QRCode";
        Session currSession = entityManager.unwrap(Session.class);
        Query<QRCode> query = currSession.createQuery(hql, QRCode.class);
        List<QRCode> list = query.getResultList();
        return list;
    }

    @Override
    public QRCode get(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        QRCode qrcode = currSession.get(QRCode.class, id);
        return qrcode;
    }

    @Override
    public void save(QRCode qrCode) {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(qrCode);
    }

    @Override
    public void delete(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        QRCode qrcode = currSession.get(QRCode.class, id);
        currSession.delete(qrcode);
    }
}
