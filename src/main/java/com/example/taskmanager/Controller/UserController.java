package com.example.taskmanager.Controller;

import com.example.taskmanager.DTO.UserDTO;
import com.example.taskmanager.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user-api/v1/users")
@RequiredArgsConstructor
@RestController
public class UserController {

        private final UserService userService;

        @GetMapping()
        public List<UserDTO> getAllUsers() {return userService.getAllUsers();}

        @GetMapping("/id/{id}")
        public UserDTO getUserById (@PathVariable Long id) {return userService.getUserById(id);}

        @PostMapping("/add")
        public void addUsers(@RequestBody UserDTO userDTO) {userService.addUsers(userDTO);}


        @DeleteMapping("/delete/{id}")
        public void deleteUsers (@PathVariable Long id) {userService.deleteUsersById(id);}

        @PatchMapping("/update_user/{userid}")
        public  void UpdateUserName (@PathVariable Long userid, String username){
                userService.UpdateUserName(userid, username);
        }
    }

