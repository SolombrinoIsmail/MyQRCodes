package ch.ismail.qrcodes.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ch.ismail.qrcodes.models.User;
import ch.ismail.qrcodes.service.interfaces.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    private static final List<User> USERS = Arrays.asList(
            new User("Ismail", "Solombrino", "isy.solombirno@gmail.com", new Date(2000, 8, 10), "0764450768", "Password", "https://de.wikipedia.org/"),
            new User("Mohamed", "Solombrino", "isy-solombrino@hotmail.com", new Date(2002, 10, 16), "0764200768", "Password", "https://de.wikipedia.org/")
    );

    @GetMapping("/user")
    public List<User> get() {
        return userService.get();
    }

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable long id) {
        return userService.get(id);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "User removed with id " + id;
    }

    @GetMapping(path = "{userID")
    public User getUser(@PathVariable("userID") Integer userID) {
        return USERS.stream().filter(user -> userID.equals(user.getUserID()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User with ID: " + userID + " does not exist"));
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
