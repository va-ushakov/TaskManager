package com.example.taskmanager.Service;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.Handler.ResourceNotFoundException;
import com.example.taskmanager.Repository.TaskRepository;
import com.example.taskmanager.Entity.Status;
import com.example.taskmanager.Entity.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;

    public List<TaskDTO> getAllTasks() {
        var taskList = taskRepository.findAll();
        List<TaskDTO> taskDTOList = new ArrayList<>();
        taskList.forEach(task -> taskDTOList.add(TaskDTO.builder()
                .name(task.getName())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .build()));
        return taskDTOList;
    }

    public Task addTasks(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTasks(Long id) {
        if (!taskRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Task with id " + id + " not found");
        }
        taskRepository.deleteById(id);
    }

    public TaskDTO getTaskById(Long id) {
        var task = taskRepository.getTaskById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task with id " + id + " not found"));
        return task != null ?
                TaskDTO.builder()
                        .name(task.getName())
                        .description(task.getDescription())
                        .priority(task.getPriority())
                        .status(task.getStatus())
                        .build() :
                null;
    }

    public void updateStatus(Long id, Status new_status) {
        var task = taskRepository.getTaskById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task with id " + id + " not found"));
            task.setStatus(new_status);
            taskRepository.save(task);
    }

}

