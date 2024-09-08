package com.example.taskmanager.Service;

import com.example.taskmanager.DTO.UserDTO;
import com.example.taskmanager.Handler.ResourceNotFoundException;
import com.example.taskmanager.Repository.UserRepository;
import com.example.taskmanager.Entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        var userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        userList.forEach(user -> userDTOList.add(UserDTO.builder()
                .userName(user.getUserName())
                .password(user.getPassword())
                .build()));
        return userDTOList;
    }

    public void addUsers(UserDTO userdto) {
        var user = User.builder()
                .userName(userdto.getUserName())
                .password(userdto.getPassword())
                .build();
        userRepository.save(user);
    }

    public void deleteUsersById(Long id) {
        if (!userRepository.existsById(id))
        {
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteUserById(id);
    }

    public UserDTO getUserById(Long id) {
        if (!userRepository.existsById(id))
        {
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
        var user = userRepository.getUserById(id).orElse(null);
        return user != null ?
                UserDTO.builder()
                        .userName(user.getUserName())
                        .password(user.getPassword())
                        .build() :
                null;
    }

    public void UpdateUserName(Long userid, String username) {
        if (!userRepository.existsById(userid))
        {
            throw new ResourceNotFoundException("User with id " + userid + " not found");
        }
        var user = userRepository.getUserById(userid).orElse(null);
            user.setUserName(username);
            userRepository.save(user);

    }

}
