package ch.ismail.qrcodes.service.implementations;

import ch.ismail.qrcodes.models.QRCode;
import ch.ismail.qrcodes.repositories.interfaces.QRCodeDAO;
import ch.ismail.qrcodes.service.interfaces.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public class QRCodeServiceImp implements QRCodeService {
    @Autowired
    private QRCodeDAO qrCodeDAO;

    @Transactional
    @Override
    public List<QRCode> get() {
        return qrCodeDAO.get();
    }

    @Transactional
    @Override
    public QRCode get(int id) {
        return qrCodeDAO.get(id);
    }

    @Transactional
    @Override
    public void save(QRCode qrCode) {
        qrCodeDAO.save(qrCode);
    }

    @Transactional
    @Override
    public void delete(int id) {
        qrCodeDAO.delete(id);
    }
}