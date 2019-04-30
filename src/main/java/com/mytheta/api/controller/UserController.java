package com.mytheta.api.controller;


import com.mytheta.api.model.User;
import com.mytheta.api.model.UserForm;
import com.mytheta.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import java.util.List;

@RestController
@RequestMapping("user-api")
public class UserController {
    @Autowired
    UserService userService;

    // POST /users 学生の登録
    @PostMapping("users")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user) { userService.save(user);
    }

    @GetMapping("users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserForm getUser(@PathVariable String id) { return userService.getUser(id);
    }

    @GetMapping("users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserForm> getUsers() {return userService.getUsers();}

    @PutMapping("users/grade/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void upgrade(@PathVariable String id) {userService.upgrade(id);}

    @PutMapping("users/graduate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void graduate(@PathVariable String id) {userService.graduate(id);}

    @DeleteMapping("users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {userService.delete(id);}

}

