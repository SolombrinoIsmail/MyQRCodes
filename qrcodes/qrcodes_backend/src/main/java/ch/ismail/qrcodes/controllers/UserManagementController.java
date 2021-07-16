package ch.ismail.qrcodes.controllers;

import ch.ismail.qrcodes.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("management/api")
public class UserManagementController {
    private static final List<User> USERS = Arrays.asList(
            new User("Ismail", "Solombrino", "isy.solombirno@gmail.com", new Date(2000, 8, 10), "0764450768", "Password", "https://de.wikipedia.org/"),
            new User("Mohamed", "Solombrino", "isy-solombrino@hotmail.com", new Date(2002, 10, 16), "0764200768", "Password", "https://de.wikipedia.org/")
    );

    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("Get Mapping: Got all users" + USERS);
        return USERS;
    }

    @PostMapping
    public void registerNewUser(User user) {
        System.out.println("Register new User:");
        System.out.println(user);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteUser(@PathVariable("userID") long userID) {
        System.out.println("Delete User:");
        System.out.println(userID);
    }

    @PutMapping(path = "{userID}")
    public void updateUser(@PathVariable("userID") int userID, @RequestBody User user) {
        System.out.println("Put/Update User:" + userID);
        System.out.println(String.format("%s %s", user, user));
    }
}