package com.cristophermartinez.sportfinal.service;

import com.cristophermartinez.sportfinal.model.User;
import com.cristophermartinez.sportfinal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplements implements UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator; // ✅ Se inyecta la clase de validación

    public UserServiceImplements(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        userValidator.validateNewUser(user); // ✅ Validación centralizada
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userValidator.validateUpdatedUser(user, existingUser); // ✅ Validación centralizada
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
