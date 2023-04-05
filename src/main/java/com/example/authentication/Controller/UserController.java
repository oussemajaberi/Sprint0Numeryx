package com.example.authentication.Controller;

import com.example.authentication.Entity.Role;
import com.example.authentication.Entity.User;
import com.example.authentication.Service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserServiceImpl userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers()
    {
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @PostMapping("/user/save")
    public User SaveUser(@RequestBody User user )
    {
        return  userService.saveUser(user);
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> SaveRole(@RequestBody  Role role )

    {
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
}
