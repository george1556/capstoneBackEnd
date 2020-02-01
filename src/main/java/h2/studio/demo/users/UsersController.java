package h2.studio.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UsersController {

    @Autowired
    private final UsersService usersService;

    public UsersController(UsersService usersService) { this.usersService = usersService; }

    @GetMapping
    public List<User> getAllUsers() { return this.usersService.getAllUsers(); }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable int id){
        User user = usersService.getOneUser(id).orElseThrow(IllegalArgumentException::new);
        return user;
    }


    //Ask John/Sean for query to find by username to see if username exists already before adding new user.
    @PostMapping
    public User addNewUser(@RequestBody User newUser){
        return usersService.addNewUser(newUser);
    }

    @PatchMapping
    public User updateUser(@RequestBody User updatedUser){
        User user = usersService.getOneUser(updatedUser.getId()).orElseThrow(IllegalArgumentException::new);
        return usersService.updateUser(updatedUser);
    }


    @DeleteMapping
    public String deleteUser(@PathVariable int id){
        User user = usersService.getOneUser(id).orElseThrow(IllegalArgumentException::new);
        return usersService.deleteUser(id);
    }



}
