package h2.studio.demo.users;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Data

public class User {
    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private Boolean admin = false;

    @Column
    private String userName = "";

    @Column
    private String password = "";

   @Column
    private int loginAttempts = 0;

    @Column
    private Boolean accountLocked = false;

    @Column
    private String firstName = "";

    @Column
    private String lastName = "";

    @Column
    private String email = "";

    @Column
    private String streetAddress = "";

    @Column
    private String zipCode = "";

    @Column
    private String city = "";

    @Column
    private String state = "";


    public int getId(){return id;}

    public String getUserName(){return userName;}

    public String getPassword(){return password;}

    public Boolean getAdmin() {
        return admin;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    //    I can use a get request to get the username, and if it matches, check the password

}
