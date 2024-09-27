package com.example.taskmanager.service;

import com.example.taskmanager.DTO.UserDTO;
import com.example.taskmanager.Repository.UserRepository;
import com.example.taskmanager.Service.UserService;
import com.example.taskmanager.Entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void GetUserById_ReturnUserDTO() {
        User user = User.builder()
                .id(1L)
                .userName("userName")
                .password("Password")
                .build();
        when(userRepository.getUserById(Mockito.anyLong())).thenReturn(Optional.ofNullable(user));
        UserDTO founduserDTO = userService.getUserById(user.getId());
        Assertions.assertThat(founduserDTO).isNotNull();
        Assertions.assertThat(founduserDTO.getUserName()).isEqualTo(user.getUserName());
        Assertions.assertThat(founduserDTO.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void GetAllUsers_ReturnUsersDTO() {
        User user1 = User.builder()
                .id(1L)
                .userName("userName1")
                .password("password1")
                .build();
        User user2 = User.builder()
                .id(2L)
                .userName("userName2")
                .password("password2")
                .build();
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        when(userRepository.findAll()).thenReturn(userList);
        List<UserDTO> userDTOList = userService.getAllUsers();
        Assertions.assertThat(userDTOList).isNotNull();
        Assertions.assertThat(userDTOList.get(0).getUserName()).isEqualTo(user1.getUserName());
        Assertions.assertThat(userDTOList.get(1).getUserName()).isEqualTo(user2.getUserName());

    }
}
