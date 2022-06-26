package com.hienvv.controller;

import com.hienvv.entity.Role;
import com.hienvv.security.UserPrincipal;
import com.hienvv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal,
                                        @PathVariable Role role) {
        userService.changeRole(userPrincipal.getUsername(), role);
        return ResponseEntity.ok(true);
    }
}
