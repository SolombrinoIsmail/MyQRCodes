package ch.ismail.qrcodes.models;

import javax.persistence.*;

@Entity
@Table(name = "qrcode")
public class QRCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    private String url;

    public QRCode() {
    }

    @Override
    public String toString() {
        return "QRCodes{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public QRCode(String url) {
        this.url = url;
    }

    public QRCode(long id, String url) {
        this.id = id;
        this.url = url;
    }
}
