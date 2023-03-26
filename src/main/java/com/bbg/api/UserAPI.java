package com.bbg.api;

import com.bbg.Requestbody.RequestbodySetFollowing;
import com.bbg.dto.UserDTO;
import com.bbg.exception.ApiRequestExeption;
import com.bbg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserAPI {
    @Autowired
    private IUserService userService;

    @PostMapping(value = "/user")
    public Object createUser(@RequestBody UserDTO model) {
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", userService.save(model));
            return res;

        } catch (Exception ex) {
            res.put("error", ex.getMessage());
            return res;
        }
    }

    @GetMapping(value = {"/user"})
    public Object getUser(@RequestParam(required = false, name = "order_direction") String oderDirection) throws ApiRequestExeption {
        return userService.getUser(oderDirection);
    }

    @GetMapping(value = "/user/{id}")
    public Object getUserById(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", userService.getUserById(id));
            return res;
        } catch (Exception ex) {
            res.put("errorMessage", ex.getMessage());
            return res;
        }
    }

    @PutMapping(value = "/user")
    public Object updateUser(@RequestBody UserDTO model) {
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", userService.save(model));
            return res;
        } catch (Exception ex) {
            throw new ApiRequestExeption(ex.getMessage());
        }
    }

    @DeleteMapping(value = "user/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PostMapping(value = "/follow")
    public Object setUserFollowing(@RequestBody RequestbodySetFollowing model) throws ApiRequestExeption{
        try {
            Object object = userService.setUserFollowing(model);
            return object;
        } catch(Exception ex) {
            throw new ApiRequestExeption(ex.getMessage());
        }
    }

    @PostMapping(value = "/un-follow")
    public Object setUserUnFollow(@RequestBody RequestbodySetFollowing model) throws ApiRequestExeption{
        try {
            Object object = userService.setUserUnfollow(model);
            return object;
        } catch(Exception ex) {
            throw new ApiRequestExeption(ex.getMessage());
        }
    }

}
