package ch.ismail.qrcodes.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthdate;
    private int phonenumber;
    private String password;
    private String qrcodes;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", phoneNumber=" + phonenumber +
                ", password='" + password + '\'' +
                ", qrCodes=" + qrcodes +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQrcodes() {
        return qrcodes;
    }

    public void setQrcodes(String qrCodes) {
        this.qrcodes = qrCodes;
    }

    public User(String firstname, String lastname, String email, Date birthdate, int phonenumber, String password, String qrcodes) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.phonenumber = phonenumber;
        this.password = password;
        this.qrcodes = qrcodes;
    }

    public User(long id, String firstname, String lastname, String email, Date birthdate, int phonenumber, String password, String qrcodes) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.phonenumber = phonenumber;
        this.password = password;
        this.qrcodes = qrcodes;
    }
}
