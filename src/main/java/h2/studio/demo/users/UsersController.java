package h2.studio.demo.users;

//import h2.studio.demo.Login.Login;
//
//
//import h2.studio.demo.Login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/users")

public class UsersController {

    @Autowired
    private final UsersService usersService;


    public UsersController(UsersService usersService) { this.usersService = usersService; }


    //Authenticates and returns a user without the password information being sent back to the front-end.

    @PostMapping("/login")
    public returnUser getOneUser(@RequestBody Login login){

        String currentUsername = login.getUsername();
        String currentPassword = login.getPassword();

        //Locates the user based on the username
        User user = usersService.findUserByUsername(currentUsername).orElseThrow(IllegalArgumentException::new);

        //Gets the password of the user
        String userPassword = user.getPassword();

        //Create an instance of returnUser to send back.
        returnUser userToReturn = new returnUser();

        //Compare and authenticate password. If password matches, return user information minus the password. If it doesn't match, return an empty instance of userToReturn and increment loginAttempts. If loginAttempts reaches 5 without a successful login, the account is locked.

        if(userPassword.equals(currentPassword) && !user.getAccountLocked()){
            userToReturn.setId(user.getId());
            userToReturn.setFirstName(user.getFirstName());
            userToReturn.setLastName(user.getLastName());
            userToReturn.setEmail(user.getEmail());
            userToReturn.setStreetAddress(user.getStreetAddress());
            userToReturn.setZipCode(user.getZipCode());
            userToReturn.setCity(user.getCity());
            userToReturn.setState(user.getState());
            userToReturn.setAdmin(user.getAdmin());
            userToReturn.setAccountLocked(user.getAccountLocked());
            userToReturn.setLoginAttempts(user.getLoginAttempts());
            userToReturn.setUserName(user.getUserName());
            //Resets the login attempts after a successful login
            user.setLoginAttempts(0);
            //Updates the user information in the database
            this.usersService.updateUser(user);
        } else {
            //Verify account isn't locked before updating any additional login attempts
            if (!user.getAccountLocked()) {
                //If a wrong password is entered, increment login attempts.
                int currentLoginAttempts = user.getLoginAttempts();
                user.setLoginAttempts(currentLoginAttempts + 1);

                //If unsuccessful login attempts reaches 5, lock the account
                if (currentLoginAttempts >= 5) {
                    user.setAccountLocked(true);
                }

                this.usersService.updateUser(user);
            }
        }

        if(user.getAccountLocked()){
                userToReturn.setAccountLocked(true);
        }


            return userToReturn;

    }










    //Ask John/Sean for query to find by username to see if username exists already before adding new user.
    @PostMapping
    public User addNewUser(@RequestBody User newUser){
        return usersService.addNewUser(newUser);
    }

//    @PostMapping
//    public User addNewUser(@RequestBody User newUser){
//        HashMap<String, String> usermap = new HashMap<>();
//        usermap.put("username", newUser.)
//        return usersService.addNewUser(newUser);
//    }



    @PatchMapping
    public User updateUser(@RequestBody User updatedUser){
        User user = usersService.getOneUser(updatedUser.getId()).orElseThrow(IllegalArgumentException::new);



        return usersService.updateUser(updatedUser);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        return usersService.deleteUser(id);
    }



}
