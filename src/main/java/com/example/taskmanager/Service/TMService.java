package com.example.taskmanager.Service;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.Handler.ResourceNotFoundException;
import com.example.taskmanager.Repository.TaskRepository;
import com.example.taskmanager.Repository.UserRepository;
import com.example.taskmanager.Entity.Priority;
import com.example.taskmanager.Entity.Task;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TMService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Transactional
    public void deleteUserWithTaskByID(Long userid) {
        taskRepository.deleteTasksByUserId(userid);
        userRepository.deleteUserById(userid);
    }

    public List<TaskDTO> getTaskByUserID(Long userid) {
        if (!userRepository.existsById(userid))
        {
            throw new ResourceNotFoundException("User with id " + userid + " not found");
        }
        List<Task> taskList = taskRepository.getTasksByUserId(userid);
        List<TaskDTO> taskDTOList = new ArrayList<>();
        taskList.forEach(task -> taskDTOList.add(TaskDTO.builder()
                .status(task.getStatus())
                .description(task.getDescription())
                .name(task.getName())
                .priority(task.getPriority())
                .build()));
        return taskDTOList;
    }

    public List<TaskDTO> getTasksByPriorityOrderByStatus(Priority priority) {
        var taskList = taskRepository.getTasksByPriorityOrderByStatus(priority);
        List<TaskDTO> taskDTOList = new ArrayList<>();
        taskList.forEach(task -> taskDTOList.add(TaskDTO.builder()
                .status(task.getStatus())
                .description(task.getDescription())
                .name(task.getName())
                .priority(task.getPriority())
                .build()));
        return taskDTOList;
    }


}

