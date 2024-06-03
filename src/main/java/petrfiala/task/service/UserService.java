package petrfiala.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import petrfiala.task.entity.User;
import petrfiala.task.model.UserWithoutPassword;
import petrfiala.task.repository.UserRepository;

import javax.validation.Valid;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserWithoutPassword getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return new UserWithoutPassword(user.getId(), user.getName(), user.getUsername());
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}

