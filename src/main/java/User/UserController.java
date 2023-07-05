package User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders ="*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/{id}")
    public User getUserById(
            @PathVariable("id") Long id) {
        return userRepository.findById(id).orElse(null);
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setName(updatedUser.getName());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}
