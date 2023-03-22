package com.bbg.api;

import com.bbg.dto.UserDTO;
import com.bbg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class UserAPI {
    @Autowired
    private IUserService userService;

    @PostMapping(value = "/user")
    public UserDTO createUser(@RequestBody UserDTO model) {
        return userService.save(model);
    }

    @GetMapping(value = {"/user"})
    public ArrayList<UserDTO> getUser(@RequestParam String oderDirection) {
        System.out.println(oderDirection);
        return userService.getUser(oderDirection);
    }

    @GetMapping(value = "/user/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

}
