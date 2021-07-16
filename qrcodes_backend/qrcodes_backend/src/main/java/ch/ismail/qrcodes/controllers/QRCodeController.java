package ch.ismail.qrcodes.controllers;

import ch.ismail.qrcodes.models.QRCode;
import ch.ismail.qrcodes.service.interfaces.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/qrcode")
    public List<QRCode> get() {
        return qrCodeService.get();
    }

    @PostMapping("/qrcode")
    public QRCode save(@RequestBody QRCode qrcode) {
        qrCodeService.save(qrcode);
        return qrcode;
    }

    @GetMapping("/qrcode/{id}")
    public QRCode get(@PathVariable long id) {
        return qrCodeService.get(id);
    }

    @DeleteMapping("/qrcode/{id}")
    public String delete(@PathVariable long id) {
        qrCodeService.delete(id);
        return "QR-Code removed with id " + id;
    }

    @PutMapping("/qrcode")
    public QRCode update(@RequestBody QRCode qrCode) {
        qrCodeService.save(qrCode);
        return qrCode;
    }
}