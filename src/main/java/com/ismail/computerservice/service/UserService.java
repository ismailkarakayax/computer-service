package com.ismail.computerservice.service;

import com.ismail.computerservice.dto.CreateUserRequestDto;
import com.ismail.computerservice.model.User;
import com.ismail.computerservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequestDto request) {

        User newUser = new User.Builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(request.getRoles())
                .build();
        return userRepository.save(newUser);
    }



        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Optional<User> user = userRepository.findByUsername(username);
            return (UserDetails) user.orElseThrow(EntityNotFoundException::new);
        }

}
