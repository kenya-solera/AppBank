package com.AppBank.AppBank.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> userOp = userRepository.findById(id);
        if(userOp.isEmpty()){
            throw new IllegalStateException("User not found");
        }
        return userOp.get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setUserName(updatedUser.getUserName());
            user.setPassword(updatedUser.getPassword());
            user.setEmail(updatedUser.getEmail());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepository.save(user);
        }
        throw new IllegalStateException("User not found");
    }

    public void deleteUser(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new IllegalStateException("User not found");
        }
        userRepository.deleteById(id);
    }
}







