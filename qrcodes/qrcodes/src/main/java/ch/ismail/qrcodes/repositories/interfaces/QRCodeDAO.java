package ch.ismail.qrcodes.repositories.interfaces;

import ch.ismail.qrcodes.models.QRCode;

import java.util.List;


public interface QRCodeDAO {
    List get();

    QRCode get(long id);

    void save(QRCode qrCode);

    void delete(long id);
}
