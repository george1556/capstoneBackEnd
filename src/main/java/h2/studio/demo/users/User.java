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


//Potentially store these in a separate table
    @Column
    private Boolean admin = false;

    @Column
    private String userName = "";

    @Column
    private String password = "";

    @Column
    private int loginAttempts = 0;

    //Separate Table above?

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

    public String getUserName(){ return userName;}

    public int getId(){return id;}



//    I can use a get request to get the username, and if it matches, check the password

}
