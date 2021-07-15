package ch.ismail.qrcodes.service.interfaces;

import ch.ismail.qrcodes.models.QRCode;

import java.util.List;

public interface QRCodeService {
    List<QRCode> get();

    QRCode get(long id);

    void save(QRCode qrCode);

    void delete(long id);
}
