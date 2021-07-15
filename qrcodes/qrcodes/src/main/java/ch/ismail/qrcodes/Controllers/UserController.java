package ch.ismail.qrcodes.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import ch.ismail.qrcodes.models.User;
import ch.ismail.qrcodes.service.interfaces.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

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

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
