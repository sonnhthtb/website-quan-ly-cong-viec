package org.sonptit.ToDo.api;


import org.sonptit.ToDo.dto.UserDTO;
import org.sonptit.ToDo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(value = "/reg")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        if(userService.findByUsername(userDTO.getUsername()) == null) {
            return userService.save(userDTO);
        }
        return null;
    }

//    @GetMapping(value = "/check")
//    public boolean checkUser(User userDTO) {
//        return userService
//    }
}
