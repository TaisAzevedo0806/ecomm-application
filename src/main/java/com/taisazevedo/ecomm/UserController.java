package com.taisazevedo.ecomm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @PostMapping
        public void createUser(@RequestBody User user) {
                userService.addUser(user);
        }

        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
                return userService.updateUser(id, newUser)
                                .map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.notFound().build());
        }

//        @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
        @GetMapping("/{id}")
        public ResponseEntity<User> getUser(@PathVariable Long id) {
                return userService.fetchUser(id)
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping
        public ResponseEntity<List<User>> getAllUsers() {
                return ResponseEntity.ok(userService.fetchAllUsers());
        }
}
