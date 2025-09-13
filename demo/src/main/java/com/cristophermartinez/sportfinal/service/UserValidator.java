package com.cristophermartinez.sportfinal.service;

import com.cristophermartinez.sportfinal.model.User;
import com.cristophermartinez.sportfinal.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Validar antes de crear
    public void validateNewUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("El email ya existe");
        }
        if (userRepository.existsByFirstName(user.getFirstName())) {
            throw new IllegalArgumentException("El nombre ya existe");
        }
        if (userRepository.existsByLastName(user.getLastName())) {
            throw new IllegalArgumentException("El apellido ya existe");
        }
    }

    // ✅ Validar antes de actualizar
    public void validateUpdatedUser(User user, User existingUser) {
        if (!user.getEmail().equals(existingUser.getEmail()) &&
                userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("El email ya existe");
        }

        if (!user.getFirstName().equals(existingUser.getFirstName()) &&
                userRepository.existsByFirstName(user.getFirstName())) {
            throw new IllegalArgumentException("El nombre ya existe");
        }

        if (!user.getLastName().equals(existingUser.getLastName()) &&
                userRepository.existsByLastName(user.getLastName())) {
            throw new IllegalArgumentException("El apellido ya existe");
        }
    }
}
