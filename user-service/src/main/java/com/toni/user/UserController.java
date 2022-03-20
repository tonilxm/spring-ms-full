package com.toni.user;

import com.toni.user.entity.User;
import com.toni.user.service.UserService;
import com.toni.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("Inside UserController.saveUser");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserVO findUser(@PathVariable Long id) {
        log.info("Inside UserController.findUser");
        return userService.findUser(id);
    }
}
