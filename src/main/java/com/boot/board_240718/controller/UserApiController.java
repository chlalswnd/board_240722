package com.boot.board_240718.controller;

import com.boot.board_240718.model.User;
import com.boot.board_240718.repository.BoardRepository;
import com.boot.board_240718.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text){
        List<User> users = null;
        if ("query".equals(method)){
            users = userRepository.findByUsernameQuery(text);
        } else {
            users = userRepository.findAll();
        }

        return users;
    }

}