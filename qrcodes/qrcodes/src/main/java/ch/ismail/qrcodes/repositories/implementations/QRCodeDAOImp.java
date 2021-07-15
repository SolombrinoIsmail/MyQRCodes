package ch.ismail.qrcodes.repositories.implementations;

import ch.ismail.qrcodes.models.QRCode;
import ch.ismail.qrcodes.repositories.interfaces.QRCodeDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class QRCodeDAOImp implements QRCodeDAO {
    @Override
    public ArrayList<QRCode> get() {
        return null;
    }

    @Override
    public QRCode get(int id) {
        return null;
    }

    @Override
    public void save(QRCode qrCode) {

    }

    @Override
    public void delete(int id) {

    }
}
