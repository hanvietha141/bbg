package com.bbg.api;

import com.bbg.dto.UserDTO;
import com.bbg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public ArrayList<UserDTO> getUser(@RequestParam(required = false, name="order_direction") String oderDirection) {
        return userService.getUser(oderDirection);
    }

    @GetMapping(value = "/user/{id}")
    public Object getUserById(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try{
            return res.put("data", userService.getUserById(id));
        } catch (Exception ex) {
            return res.put("errorMessage", ex.getMessage());
        }
    }

    @PutMapping(value="/user")
    public UserDTO updateUser(@RequestBody UserDTO model) {
        return userService.save(model);
    }

    @DeleteMapping(value="user/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
