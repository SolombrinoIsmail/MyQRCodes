package ch.ismail.qrcodes.repositories.interfaces;

import ch.ismail.qrcodes.models.QRCode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QRCodeDAO {
    ArrayList<QRCode> get();

    QRCode get(int id);

    void save(QRCode qrCode);

    void delete(int id);
}
