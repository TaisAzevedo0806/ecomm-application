package com.taisazevedo.ecomm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
        private final UserRepository userRepository;

        public void addUser(User user) {
                userRepository.save(user);
        }

        public Optional<User> updateUser(Long id, User newUser) {
                newUser.setId(id);
                userRepository.save(newUser);
                return fetchUser(id);
        }

        public Optional<User> fetchUser(Long id) {
                return userRepository.findById(id);
        }

        public List<User> fetchAllUsers() {
                return userRepository.findAll();
        }
}
