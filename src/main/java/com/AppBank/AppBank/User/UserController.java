package com.AppBank.AppBank.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders ="*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userSrvc;


    @GetMapping
    public Iterable<User> getUsers() {
        return userSrvc.getUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userSrvc.getUserById(id);
    }

    @GetMapping("/get/{userName}")
    public Object getUserByUsername(@PathVariable("userName") String userName) {
        User usu = userSrvc.getUserByUserName(userName);

        if (usu == null || usu.getUserName().isEmpty()) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return usu;
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userSrvc.createUser(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        return userSrvc.updateUser(id, updatedUser);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userSrvc.deleteUser(id);
    }
}
