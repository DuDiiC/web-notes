package pl.maciejdudek.project.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.maciejdudek.project.exceptions.UserAlreadyExistException;
import pl.maciejdudek.project.model.User;
import pl.maciejdudek.project.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        if(userRepository.findByUsernameIgnoringCase(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        user.setEnabled(false);
        return userRepository.save(user);
    }
}
