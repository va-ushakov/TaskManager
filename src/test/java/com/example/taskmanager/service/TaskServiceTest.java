package com.example.taskmanager.service;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.Repository.TaskRepository;
import com.example.taskmanager.Service.TaskService;
import com.example.taskmanager.Entity.Priority;
import com.example.taskmanager.Entity.Status;
import com.example.taskmanager.Entity.Task;
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
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;
    @Test
    public void GetALlTasksReturnTaskDTO (){
        Task task1 = Task.builder()
                .id(1L)
                .name("task1Name")
                .description("task1Description")
                .priority(Priority.DEFAULT)
                .status(Status.COMPLETED)
                .build();
        Task task2 = Task.builder()
                .id(2L)
                .name("task2Name")
                .description("task2Description")
                .priority(Priority.HIGH)
                .status(Status.IN_PROCESS)
                .build();
        List<Task> taskList= new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        when(taskRepository.findAll()).thenReturn(taskList);
        List<TaskDTO> taskDTOList = taskService.getAllTasks();
        Assertions.assertThat(taskDTOList).isNotNull();
        //Assertions.assertThat(taskDTOList.get(0).getName()).isEqualTo(task1.getName());
        Assertions.assertThat(taskDTOList.get(1).getName()).isEqualTo(task2.getName());
    }

    @Test
    public void GetTaskById_ReturnTaskDTO()
    {
        Task task = Task.builder()
                .id(1L)
                .name("taskName")
                .description("taskDescription")
                .priority(Priority.DEFAULT)
                .status(Status.COMPLETED)
                .build();
        when(taskRepository.getTaskById(Mockito.anyLong())).thenReturn(Optional.ofNullable(task));
        TaskDTO foundTaskDTO = taskService.getTaskById(task.getId());
        Assertions.assertThat(foundTaskDTO).isNotNull();
        Assertions.assertThat(foundTaskDTO.getName()).isEqualTo(task.getName());
        Assertions.assertThat(foundTaskDTO.getDescription()).isEqualTo(task.getDescription());
    }
}
